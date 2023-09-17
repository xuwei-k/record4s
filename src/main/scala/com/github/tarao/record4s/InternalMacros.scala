package com.github.tarao.record4s

import scala.annotation.tailrec

private[record4s] class InternalMacros(using scala.quoted.Quotes) {
  import scala.quoted.*
  import quotes.reflect.*

  case class Schema(
    fieldTypes: Seq[(String, Type[_])],
    tags: Seq[Type[_]],
  ) {
    def ++(other: Schema): Schema = copy(
      fieldTypes = fieldTypes ++ other.fieldTypes,
      tags       = tags ++ other.tags,
    )

    def ++(other: Seq[(String, Type[_])]): Schema = copy(
      fieldTypes = fieldTypes ++ other,
    )

    def deduped: (Schema, Seq[(String, Type[_])]) = {
      val seen = collection.mutable.HashSet[String]()
      val deduped = collection.mutable.ListBuffer.empty[(String, Type[_])]
      val duplications = collection.mutable.ListBuffer.empty[(String, Type[_])]
      fieldTypes.reverseIterator.foreach { case (label, tpe) =>
        if (seen.add(label)) deduped.prepend((label, tpe))
        else duplications.prepend((label, tpe))
      }

      (copy(fieldTypes = deduped.toSeq), duplications.toSeq)
    }

    def asType: Type[_] = {
      // Generates:
      //   % {
      //     val ${schema(0)._1}: ${schema(0)._2}
      //     val ${schema(1)._1}: ${schema(1)._2}
      //     ...
      //   }
      // where it is actually
      //   (...((%
      //     & { val ${schema(0)._1}: ${schema(0)._2} })
      //     & { val ${schema(1)._1}: ${schema(1)._2} })
      //     ...)
      val base = fieldTypes
        .foldLeft(TypeRepr.of[%]) { case (base, (label, '[tpe])) =>
          Refinement(base, label, TypeRepr.of[tpe])
        }

      tags
        .foldLeft(base) { case (base, '[tag]) =>
          AndType(base, TypeRepr.of[Tag[tag]])
        }
        .asType
    }
  }
  object Schema {
    val empty = apply(Seq.empty, Seq.empty)
  }

  def validatedLabel(
    label: String,
    context: Option[Expr[Any]] = None,
  ): String = {
    def errorAndAbort(msg: String, context: Option[Expr[Any]]): Nothing =
      context match {
        case Some(expr) =>
          report.errorAndAbort(msg, expr)
        case None =>
          report.errorAndAbort(msg)
      }

    if (label.isEmpty)
      errorAndAbort(
        "Field label must be a non-empty string",
        context,
      )
    else if (label.contains("$"))
      // We can't allow "$" because
      // - (1) Scala compiler passes encoded name to `selectDynamic`, and
      // - (2) "$" itself never gets encoded i.e. we can't distinguish for example between
      //       "$minus-" and "--" (both are encoded to "$minus$minus").
      errorAndAbort(
        "'$' cannot be used as field label",
        context,
      )
    else
      label
  }

  def evidenceOf[T: Type]: Expr[T] =
    Expr.summon[T].getOrElse {
      report.errorAndAbort(
        s"No given instance of ${Type.show[T]}",
      )
    }

  def schemaOf[R: Type]: Schema = {
    // Check if tpr represents Tag[T]: we need to check IsTag[Tag[T]] given instance
    // because representation of opaque type varies among different package names such as
    // Tag$package.Tag[T] or $proxyN.Tag[T].
    def isTag(tpr: TypeRepr): Boolean =
      tpr.asType match {
        case '[tpe] => Expr.summon[Tag.IsTag[tpe]].nonEmpty
        case _      => false
      }

    @tailrec def collectTupledFieldTypes(
      tpe: Type[_],
      acc: Seq[(String, Type[_])],
    ): Seq[(String, Type[_])] = tpe match {
      case '[(labelType, valueType) *: rest] =>
        TypeRepr.of[labelType] match {
          case ConstantType(StringConstant(label)) =>
            collectTupledFieldTypes(
              Type.of[rest],
              acc :+ (validatedLabel(label), Type.of[valueType]),
            )
          case _ =>
            collectTupledFieldTypes(Type.of[rest], acc)
        }
      case _ =>
        acc
    }

    @tailrec def collectFieldTypesAndTags(
      reversed: List[TypeRepr],
      acc: Schema,
    ): Schema = reversed match {
      // base { label: valueType }
      // For example
      //   TypeRepr.of[%{val name: String; val age: Int}]
      // is
      //   Refinement(
      //     Refinement(
      //       TypeRepr.of[%],
      //       "name",
      //       TypeRepr.of[String]
      //     ),
      //     "age",
      //     TypeRepr.of[Int]
      //   )
      case Refinement(base, label, valueType) :: rest =>
        collectFieldTypesAndTags(
          base :: rest,
          acc.copy(fieldTypes =
            (validatedLabel(label), valueType.asType) +: acc.fieldTypes,
          ),
        )

      // tpr1 & tpr2
      case AndType(tpr1, tpr2) :: rest =>
        collectFieldTypesAndTags(tpr2 :: tpr1 :: rest, acc)

      // Tag[T]
      case (head @ AppliedType(_, List(tpr))) :: rest if isTag(head) =>
        collectFieldTypesAndTags(
          rest,
          acc.copy(tags = tpr.asType +: acc.tags),
        )

      // typically `%` in `% { ... }` or
      // (tp1, ...)
      // tp1 *: ...
      case head :: rest =>
        collectFieldTypesAndTags(
          rest,
          acc.copy(fieldTypes =
            collectTupledFieldTypes(head.asType, Seq.empty) ++ acc.fieldTypes,
          ),
        )

      // all done
      case Nil =>
        acc
    }

    collectFieldTypesAndTags(List(TypeRepr.of[R]), Schema.empty)
  }

  def schemaOf[R: Type](
    recordLike: Expr[RecordLike[R]],
  ): Schema =
    if (TypeRepr.of[R] <:< TypeRepr.of[%])
      // Use R directly for % types: it in theroy should work fine with
      // RecordLike[R]#FieldTypes for R <: %, but it sometimes drops Tag[T] in R.
      schemaOf[R]
    else
      recordLike match {
        case '{ ${ _ }: RecordLike[R] { type FieldTypes = fieldTypes } } =>
          schemaOf[fieldTypes]
      }

  def fieldTypesOf(
    fields: Seq[Expr[(String, Any)]],
  ): Seq[(String, Type[_])] = {
    def fieldTypeOf(
      labelExpr: Expr[Any],
      valueExpr: Expr[Any],
    ): (String, Type[_]) = {
      val label = labelExpr.asTerm match {
        case Literal(StringConstant(label)) =>
          validatedLabel(label, Some(labelExpr))
        case _ =>
          report.errorAndAbort(
            "Field label must be a literal string",
            labelExpr,
          )
      }
      val tpe = valueExpr match {
        case '{ ${ _ }: tp } => TypeRepr.of[tp].widen.asType
      }
      (label, tpe)
    }

    fields.map {
      // ("label", value)
      case '{ ($labelExpr, $valueExpr) } =>
        fieldTypeOf(labelExpr, valueExpr)

      // "label" -> value
      case '{ ArrowAssoc(${ labelExpr }: String).->(${ valueExpr }) } =>
        fieldTypeOf(labelExpr, valueExpr)

      case expr =>
        report.errorAndAbort(s"Invalid field", expr)
    }
  }

  def iterableOf[R: Type](
    record: Expr[R],
  ): (Expr[Iterable[(String, Any)]], Schema) = {
    val ev = evidenceOf[RecordLike[R]]
    val schema = schemaOf(ev)
    ('{ ${ ev }.iterableOf($record) }, schema)
  }

  def tidiedIterableOf[R: Type](
    record: Expr[R],
  ): (Expr[Iterable[(String, Any)]], Schema) = {
    val (rec, schema) = iterableOf(record)

    // Generates:
    //   {
    //     val keys = Set(${schema(0)._1}, ${schema(1)._1}, ...)
    //     ${rec}.filter { case (key, _) => keys.contains(key) }
    //   }
    val keysExpr = schema.fieldTypes.map(field => Expr(field._1))
    val setExpr = '{ Set(${ Expr.ofSeq(keysExpr) }: _*) }
    val iterableExpr = '{
      val keys = $setExpr
      ${ rec }.filter { case (key, _) => keys.contains(key) }
    }
    (iterableExpr, schema)
  }

  def newMapRecord[R: Type](record: Expr[Iterable[(String, Any)]]): Expr[R] =
    '{ new MapRecord(${ record }.toMap).asInstanceOf[R] }

  def extend(
    record: Expr[Iterable[(String, Any)]],
    fields: Expr[IterableOnce[(String, Any)]],
  )(newSchema: Type[_]): Expr[Any] =
    newSchema match {
      case '[tpe] =>
        newMapRecord[tpe]('{ ${ record } ++ ${ fields } })
    }
}

private[record4s] object InternalMacros {
  given (using scala.quoted.Quotes): InternalMacros = new InternalMacros
}
