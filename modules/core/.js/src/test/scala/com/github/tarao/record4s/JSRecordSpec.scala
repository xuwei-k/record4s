/*
 * Copyright 2023 record4s authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.tarao.record4s

import scala.scalajs.js

class JSRecordSpec extends helper.UnitSpec {
  describe("% in JS") {
    describe("fromJS") {
      it("should convert js.Any to %") {
        val obj: js.Any = js.Dynamic.literal(name = "tarao", age = 3)
        val r = Record.fromJS[% { val name: String; val age: Int }](obj)
        r shouldStaticallyBe a[% { val name: String; val age: Int }]
        r.name shouldBe "tarao"
        r.age shouldBe 3
      }

      it("should convert js.Any to nested record") {
        val obj: js.Any = js
          .Dynamic
          .literal(
            name = "tarao",
            age  = 3,
            email = js
              .Dynamic
              .literal(
                local  = "tarao",
                domain = "example.com",
              ),
          )
        val r = Record.fromJS[
          % {
            val name: String
            val age: Int
            val email: % {
              val local: String
              val domain: String
            }
          },
        ](obj)
        r shouldStaticallyBe a[
          % {
            val name: String
            val age: Int
            val email: % {
              val local: String
              val domain: String
            }
          },
        ]
        r.name shouldBe "tarao"
        r.age shouldBe 3
        r.email.local shouldBe "tarao"
        r.email.domain shouldBe "example.com"
      }

      it("should ignore extra fields") {
        val obj: js.Any = js.Dynamic.literal(name = "tarao", age = 3)
        val r = Record.fromJS[% { val name: String }](obj)
        r shouldStaticallyBe a[% { val name: String }]
        r.name shouldBe "tarao"
        "r.age" shouldNot typeCheck
      }

      it("should fill nulls for missing fields") {
        val obj: js.Any = js.Dynamic.literal()
        val r = Record.fromJS[% { val name: String; val age: Int }](obj)
        r shouldStaticallyBe a[% { val name: String; val age: Int }]
        r.name shouldBe null
        r.age shouldBe 0
      }

      it("should throw if an object field is missing") {
        val obj: js.Any = js.Dynamic.literal(name = "tarao", age = 3)
        a[java.lang.RuntimeException] should be thrownBy
          Record.fromJS[
            % {
              val name: String
              val age: Int
              val email: % {
                val local: String
                val domain: String
              }
            },
          ](obj)
      }
    }

    describe("fromJSON") {
      it("should convert JSON String to %") {
        val json = """{"name":"tarao","age":3}"""
        val r = Record.fromJSON[% { val name: String; val age: Int }](json)
        r shouldStaticallyBe a[% { val name: String; val age: Int }]
        r.name shouldBe "tarao"
        r.age shouldBe 3
      }

      it("should convert JSON String to nested record") {
        val json =
          """{"name":"tarao","age":3,"email":{"local":"tarao","domain":"example.com"}}"""
        val r = Record.fromJSON[
          % {
            val name: String
            val age: Int
            val email: % {
              val local: String
              val domain: String
            }
          },
        ](json)
        r shouldStaticallyBe a[
          % {
            val name: String
            val age: Int
            val email: % {
              val local: String
              val domain: String
            }
          },
        ]
        r.name shouldBe "tarao"
        r.age shouldBe 3
        r.email.local shouldBe "tarao"
        r.email.domain shouldBe "example.com"
      }

      it("should ignore extra fields") {
        val json = """{"name":"tarao","age":3}"""
        val r = Record.fromJSON[% { val name: String }](json)
        r shouldStaticallyBe a[% { val name: String }]
        r.name shouldBe "tarao"
        "r.age" shouldNot typeCheck
      }

      it("should fill nulls for missing fields") {
        val json = """{}"""
        val r = Record.fromJSON[% { val name: String; val age: Int }](json)
        r shouldStaticallyBe a[% { val name: String; val age: Int }]
        r.name shouldBe null
        r.age shouldBe 0
      }

      it("should throw if an object field is missing") {
        val json = """{"name":"tarao","age":3}"""
        a[java.lang.RuntimeException] should be thrownBy
          Record.fromJS[
            % {
              val name: String
              val age: Int
              val email: % {
                val local: String
                val domain: String
              }
            },
          ](json)
      }
    }

    describe("toJS") {
      it("should convert % to js.Any") {
        val r = %(name = "tarao", age = 3)
        val obj = r.toJS
        obj shouldStaticallyBe a[js.Any]
        js.JSON.stringify(obj) shouldBe """{"name":"tarao","age":3}"""
      }

      it("should convert nested % to js.Any") {
        val r = %(
          name = "tarao",
          age  = 3,
          email = %(
            local  = "tarao",
            domain = "example.com",
          ),
        )
        val obj = r.toJS
        obj shouldStaticallyBe a[js.Any]
        js.JSON.stringify(obj) shouldBe """{"name":"tarao","age":3,"email":{"local":"tarao","domain":"example.com"}}"""
      }
    }

    describe("toJSON") {
      it("should convert % to JSON String") {
        val r = %(name = "tarao", age = 3)
        val json = r.toJSON
        json shouldBe """{"name":"tarao","age":3}"""
      }

      it("should convert nested % to JSON String") {
        val r = %(
          name = "tarao",
          age  = 3,
          email = %(
            local  = "tarao",
            domain = "example.com",
          ),
        )
        val json = r.toJSON
        json shouldBe """{"name":"tarao","age":3,"email":{"local":"tarao","domain":"example.com"}}"""
      }
    }

    describe("With NativeConverter") {
      it("can be converted if a reocrd type appears as a nested type") {
        locally {
          import org.getshaka.nativeconverter.fromJson

          val json = """[{"name":"tarao","age":3}]"""
          val seq = json.fromJson[Seq[% { val name: String; val age: Int }]]
          seq shouldStaticallyBe a[Seq[% { val name: String; val age: Int }]]
          seq(0).name shouldBe "tarao"
          seq(0).age shouldBe 3
        }

        locally {
          import org.getshaka.nativeconverter.NativeConverter.SeqConv

          val s = Seq(
            %(name = "tarao", age = 3),
            %(name = "ikura", age = 1),
          )
          val json = s.toJson
          json shouldBe """[{"name":"tarao","age":3},{"name":"ikura","age":1}]"""
        }
      }
    }
  }
}
