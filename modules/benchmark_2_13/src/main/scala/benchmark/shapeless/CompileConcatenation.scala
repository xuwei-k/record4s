package benchmark
package shapeless

import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations._

@BenchmarkMode(Array(Mode.SingleShotTime))
@OutputTimeUnit(TimeUnit.SECONDS)
@State(Scope.Thread)
class CompileConcatenation {
  @Param(Array("1", "20", "40", "60", "80", "100", "120"))
  var size: Int = 0

  var source: String = ""

  var compiler: Compiler = null

  @Setup(Level.Iteration)
  def setup(): Unit = {
    compiler = new Compiler

    source = s"""
      |import benchmark.shapeless.CompileConcatenation._
      |import _root_.shapeless.record._
      |object A {
      |  r1_${size}.merge(r2_${size})
      |}
      |""".stripMargin
  }

  @Benchmark
  def concat_fN =
    compiler.compile(source)
}

object CompileConcatenation {
  import _root_.shapeless.record._

  val r1_1 = Record(
    f1 = 1,
  )
  val r1_20 = Record(
    f1 = 1,
    f2 = 2,
    f3 = 3,
    f4 = 4,
    f5 = 5,
    f6 = 6,
    f7 = 7,
    f8 = 8,
    f9 = 9,
    f10 = 10,
    f11 = 11,
    f12 = 12,
    f13 = 13,
    f14 = 14,
    f15 = 15,
    f16 = 16,
    f17 = 17,
    f18 = 18,
    f19 = 19,
    f20 = 20,
  )
  val r1_40 = Record(
    f1 = 1,
    f2 = 2,
    f3 = 3,
    f4 = 4,
    f5 = 5,
    f6 = 6,
    f7 = 7,
    f8 = 8,
    f9 = 9,
    f10 = 10,
    f11 = 11,
    f12 = 12,
    f13 = 13,
    f14 = 14,
    f15 = 15,
    f16 = 16,
    f17 = 17,
    f18 = 18,
    f19 = 19,
    f20 = 20,
    f21 = 21,
    f22 = 22,
    f23 = 23,
    f24 = 24,
    f25 = 25,
    f26 = 26,
    f27 = 27,
    f28 = 28,
    f29 = 29,
    f30 = 30,
    f31 = 31,
    f32 = 32,
    f33 = 33,
    f34 = 34,
    f35 = 35,
    f36 = 36,
    f37 = 37,
    f38 = 38,
    f39 = 39,
    f40 = 40,
  )
  val r1_60 = Record(
    f1 = 1,
    f2 = 2,
    f3 = 3,
    f4 = 4,
    f5 = 5,
    f6 = 6,
    f7 = 7,
    f8 = 8,
    f9 = 9,
    f10 = 10,
    f11 = 11,
    f12 = 12,
    f13 = 13,
    f14 = 14,
    f15 = 15,
    f16 = 16,
    f17 = 17,
    f18 = 18,
    f19 = 19,
    f20 = 20,
    f21 = 21,
    f22 = 22,
    f23 = 23,
    f24 = 24,
    f25 = 25,
    f26 = 26,
    f27 = 27,
    f28 = 28,
    f29 = 29,
    f30 = 30,
    f31 = 31,
    f32 = 32,
    f33 = 33,
    f34 = 34,
    f35 = 35,
    f36 = 36,
    f37 = 37,
    f38 = 38,
    f39 = 39,
    f40 = 40,
    f41 = 41,
    f42 = 42,
    f43 = 43,
    f44 = 44,
    f45 = 45,
    f46 = 46,
    f47 = 47,
    f48 = 48,
    f49 = 49,
    f50 = 50,
    f51 = 51,
    f52 = 52,
    f53 = 53,
    f54 = 54,
    f55 = 55,
    f56 = 56,
    f57 = 57,
    f58 = 58,
    f59 = 59,
    f60 = 60,
  )
  val r1_80 = Record(
    f1 = 1,
    f2 = 2,
    f3 = 3,
    f4 = 4,
    f5 = 5,
    f6 = 6,
    f7 = 7,
    f8 = 8,
    f9 = 9,
    f10 = 10,
    f11 = 11,
    f12 = 12,
    f13 = 13,
    f14 = 14,
    f15 = 15,
    f16 = 16,
    f17 = 17,
    f18 = 18,
    f19 = 19,
    f20 = 20,
    f21 = 21,
    f22 = 22,
    f23 = 23,
    f24 = 24,
    f25 = 25,
    f26 = 26,
    f27 = 27,
    f28 = 28,
    f29 = 29,
    f30 = 30,
    f31 = 31,
    f32 = 32,
    f33 = 33,
    f34 = 34,
    f35 = 35,
    f36 = 36,
    f37 = 37,
    f38 = 38,
    f39 = 39,
    f40 = 40,
    f41 = 41,
    f42 = 42,
    f43 = 43,
    f44 = 44,
    f45 = 45,
    f46 = 46,
    f47 = 47,
    f48 = 48,
    f49 = 49,
    f50 = 50,
    f51 = 51,
    f52 = 52,
    f53 = 53,
    f54 = 54,
    f55 = 55,
    f56 = 56,
    f57 = 57,
    f58 = 58,
    f59 = 59,
    f60 = 60,
    f61 = 61,
    f62 = 62,
    f63 = 63,
    f64 = 64,
    f65 = 65,
    f66 = 66,
    f67 = 67,
    f68 = 68,
    f69 = 69,
    f70 = 70,
    f71 = 71,
    f72 = 72,
    f73 = 73,
    f74 = 74,
    f75 = 75,
    f76 = 76,
    f77 = 77,
    f78 = 78,
    f79 = 79,
    f80 = 80,
  )
  val r1_100 = Record(
    f1 = 1,
    f2 = 2,
    f3 = 3,
    f4 = 4,
    f5 = 5,
    f6 = 6,
    f7 = 7,
    f8 = 8,
    f9 = 9,
    f10 = 10,
    f11 = 11,
    f12 = 12,
    f13 = 13,
    f14 = 14,
    f15 = 15,
    f16 = 16,
    f17 = 17,
    f18 = 18,
    f19 = 19,
    f20 = 20,
    f21 = 21,
    f22 = 22,
    f23 = 23,
    f24 = 24,
    f25 = 25,
    f26 = 26,
    f27 = 27,
    f28 = 28,
    f29 = 29,
    f30 = 30,
    f31 = 31,
    f32 = 32,
    f33 = 33,
    f34 = 34,
    f35 = 35,
    f36 = 36,
    f37 = 37,
    f38 = 38,
    f39 = 39,
    f40 = 40,
    f41 = 41,
    f42 = 42,
    f43 = 43,
    f44 = 44,
    f45 = 45,
    f46 = 46,
    f47 = 47,
    f48 = 48,
    f49 = 49,
    f50 = 50,
    f51 = 51,
    f52 = 52,
    f53 = 53,
    f54 = 54,
    f55 = 55,
    f56 = 56,
    f57 = 57,
    f58 = 58,
    f59 = 59,
    f60 = 60,
    f61 = 61,
    f62 = 62,
    f63 = 63,
    f64 = 64,
    f65 = 65,
    f66 = 66,
    f67 = 67,
    f68 = 68,
    f69 = 69,
    f70 = 70,
    f71 = 71,
    f72 = 72,
    f73 = 73,
    f74 = 74,
    f75 = 75,
    f76 = 76,
    f77 = 77,
    f78 = 78,
    f79 = 79,
    f80 = 80,
    f81 = 81,
    f82 = 82,
    f83 = 83,
    f84 = 84,
    f85 = 85,
    f86 = 86,
    f87 = 87,
    f88 = 88,
    f89 = 89,
    f90 = 90,
    f91 = 91,
    f92 = 92,
    f93 = 93,
    f94 = 94,
    f95 = 95,
    f96 = 96,
    f97 = 97,
    f98 = 98,
    f99 = 99,
    f100 = 100,
  )
  val r1_120 = Record(
    f1 = 1,
    f2 = 2,
    f3 = 3,
    f4 = 4,
    f5 = 5,
    f6 = 6,
    f7 = 7,
    f8 = 8,
    f9 = 9,
    f10 = 10,
    f11 = 11,
    f12 = 12,
    f13 = 13,
    f14 = 14,
    f15 = 15,
    f16 = 16,
    f17 = 17,
    f18 = 18,
    f19 = 19,
    f20 = 20,
    f21 = 21,
    f22 = 22,
    f23 = 23,
    f24 = 24,
    f25 = 25,
    f26 = 26,
    f27 = 27,
    f28 = 28,
    f29 = 29,
    f30 = 30,
    f31 = 31,
    f32 = 32,
    f33 = 33,
    f34 = 34,
    f35 = 35,
    f36 = 36,
    f37 = 37,
    f38 = 38,
    f39 = 39,
    f40 = 40,
    f41 = 41,
    f42 = 42,
    f43 = 43,
    f44 = 44,
    f45 = 45,
    f46 = 46,
    f47 = 47,
    f48 = 48,
    f49 = 49,
    f50 = 50,
    f51 = 51,
    f52 = 52,
    f53 = 53,
    f54 = 54,
    f55 = 55,
    f56 = 56,
    f57 = 57,
    f58 = 58,
    f59 = 59,
    f60 = 60,
    f61 = 61,
    f62 = 62,
    f63 = 63,
    f64 = 64,
    f65 = 65,
    f66 = 66,
    f67 = 67,
    f68 = 68,
    f69 = 69,
    f70 = 70,
    f71 = 71,
    f72 = 72,
    f73 = 73,
    f74 = 74,
    f75 = 75,
    f76 = 76,
    f77 = 77,
    f78 = 78,
    f79 = 79,
    f80 = 80,
    f81 = 81,
    f82 = 82,
    f83 = 83,
    f84 = 84,
    f85 = 85,
    f86 = 86,
    f87 = 87,
    f88 = 88,
    f89 = 89,
    f90 = 90,
    f91 = 91,
    f92 = 92,
    f93 = 93,
    f94 = 94,
    f95 = 95,
    f96 = 96,
    f97 = 97,
    f98 = 98,
    f99 = 99,
    f100 = 100,
    f101 = 101,
    f102 = 102,
    f103 = 103,
    f104 = 104,
    f105 = 105,
    f106 = 106,
    f107 = 107,
    f108 = 108,
    f109 = 109,
    f110 = 110,
    f111 = 111,
    f112 = 112,
    f113 = 113,
    f114 = 114,
    f115 = 115,
    f116 = 116,
    f117 = 117,
    f118 = 118,
    f119 = 119,
    f120 = 120,
  )
  val r2_1 = Record(
    f1 = 1,
  )
  val r2_20 = Record(
    f1 = 1,
    f2 = 2,
    f3 = 3,
    f4 = 4,
    f5 = 5,
    f6 = 6,
    f7 = 7,
    f8 = 8,
    f9 = 9,
    f10 = 10,
    f11 = 11,
    f12 = 12,
    f13 = 13,
    f14 = 14,
    f15 = 15,
    f16 = 16,
    f17 = 17,
    f18 = 18,
    f19 = 19,
    f20 = 20,
  )
  val r2_40 = Record(
    f1 = 1,
    f2 = 2,
    f3 = 3,
    f4 = 4,
    f5 = 5,
    f6 = 6,
    f7 = 7,
    f8 = 8,
    f9 = 9,
    f10 = 10,
    f11 = 11,
    f12 = 12,
    f13 = 13,
    f14 = 14,
    f15 = 15,
    f16 = 16,
    f17 = 17,
    f18 = 18,
    f19 = 19,
    f20 = 20,
    f21 = 21,
    f22 = 22,
    f23 = 23,
    f24 = 24,
    f25 = 25,
    f26 = 26,
    f27 = 27,
    f28 = 28,
    f29 = 29,
    f30 = 30,
    f31 = 31,
    f32 = 32,
    f33 = 33,
    f34 = 34,
    f35 = 35,
    f36 = 36,
    f37 = 37,
    f38 = 38,
    f39 = 39,
    f40 = 40,
  )
  val r2_60 = Record(
    f1 = 1,
    f2 = 2,
    f3 = 3,
    f4 = 4,
    f5 = 5,
    f6 = 6,
    f7 = 7,
    f8 = 8,
    f9 = 9,
    f10 = 10,
    f11 = 11,
    f12 = 12,
    f13 = 13,
    f14 = 14,
    f15 = 15,
    f16 = 16,
    f17 = 17,
    f18 = 18,
    f19 = 19,
    f20 = 20,
    f21 = 21,
    f22 = 22,
    f23 = 23,
    f24 = 24,
    f25 = 25,
    f26 = 26,
    f27 = 27,
    f28 = 28,
    f29 = 29,
    f30 = 30,
    f31 = 31,
    f32 = 32,
    f33 = 33,
    f34 = 34,
    f35 = 35,
    f36 = 36,
    f37 = 37,
    f38 = 38,
    f39 = 39,
    f40 = 40,
    f41 = 41,
    f42 = 42,
    f43 = 43,
    f44 = 44,
    f45 = 45,
    f46 = 46,
    f47 = 47,
    f48 = 48,
    f49 = 49,
    f50 = 50,
    f51 = 51,
    f52 = 52,
    f53 = 53,
    f54 = 54,
    f55 = 55,
    f56 = 56,
    f57 = 57,
    f58 = 58,
    f59 = 59,
    f60 = 60,
  )
  val r2_80 = Record(
    f1 = 1,
    f2 = 2,
    f3 = 3,
    f4 = 4,
    f5 = 5,
    f6 = 6,
    f7 = 7,
    f8 = 8,
    f9 = 9,
    f10 = 10,
    f11 = 11,
    f12 = 12,
    f13 = 13,
    f14 = 14,
    f15 = 15,
    f16 = 16,
    f17 = 17,
    f18 = 18,
    f19 = 19,
    f20 = 20,
    f21 = 21,
    f22 = 22,
    f23 = 23,
    f24 = 24,
    f25 = 25,
    f26 = 26,
    f27 = 27,
    f28 = 28,
    f29 = 29,
    f30 = 30,
    f31 = 31,
    f32 = 32,
    f33 = 33,
    f34 = 34,
    f35 = 35,
    f36 = 36,
    f37 = 37,
    f38 = 38,
    f39 = 39,
    f40 = 40,
    f41 = 41,
    f42 = 42,
    f43 = 43,
    f44 = 44,
    f45 = 45,
    f46 = 46,
    f47 = 47,
    f48 = 48,
    f49 = 49,
    f50 = 50,
    f51 = 51,
    f52 = 52,
    f53 = 53,
    f54 = 54,
    f55 = 55,
    f56 = 56,
    f57 = 57,
    f58 = 58,
    f59 = 59,
    f60 = 60,
    f61 = 61,
    f62 = 62,
    f63 = 63,
    f64 = 64,
    f65 = 65,
    f66 = 66,
    f67 = 67,
    f68 = 68,
    f69 = 69,
    f70 = 70,
    f71 = 71,
    f72 = 72,
    f73 = 73,
    f74 = 74,
    f75 = 75,
    f76 = 76,
    f77 = 77,
    f78 = 78,
    f79 = 79,
    f80 = 80,
  )
  val r2_100 = Record(
    f1 = 1,
    f2 = 2,
    f3 = 3,
    f4 = 4,
    f5 = 5,
    f6 = 6,
    f7 = 7,
    f8 = 8,
    f9 = 9,
    f10 = 10,
    f11 = 11,
    f12 = 12,
    f13 = 13,
    f14 = 14,
    f15 = 15,
    f16 = 16,
    f17 = 17,
    f18 = 18,
    f19 = 19,
    f20 = 20,
    f21 = 21,
    f22 = 22,
    f23 = 23,
    f24 = 24,
    f25 = 25,
    f26 = 26,
    f27 = 27,
    f28 = 28,
    f29 = 29,
    f30 = 30,
    f31 = 31,
    f32 = 32,
    f33 = 33,
    f34 = 34,
    f35 = 35,
    f36 = 36,
    f37 = 37,
    f38 = 38,
    f39 = 39,
    f40 = 40,
    f41 = 41,
    f42 = 42,
    f43 = 43,
    f44 = 44,
    f45 = 45,
    f46 = 46,
    f47 = 47,
    f48 = 48,
    f49 = 49,
    f50 = 50,
    f51 = 51,
    f52 = 52,
    f53 = 53,
    f54 = 54,
    f55 = 55,
    f56 = 56,
    f57 = 57,
    f58 = 58,
    f59 = 59,
    f60 = 60,
    f61 = 61,
    f62 = 62,
    f63 = 63,
    f64 = 64,
    f65 = 65,
    f66 = 66,
    f67 = 67,
    f68 = 68,
    f69 = 69,
    f70 = 70,
    f71 = 71,
    f72 = 72,
    f73 = 73,
    f74 = 74,
    f75 = 75,
    f76 = 76,
    f77 = 77,
    f78 = 78,
    f79 = 79,
    f80 = 80,
    f81 = 81,
    f82 = 82,
    f83 = 83,
    f84 = 84,
    f85 = 85,
    f86 = 86,
    f87 = 87,
    f88 = 88,
    f89 = 89,
    f90 = 90,
    f91 = 91,
    f92 = 92,
    f93 = 93,
    f94 = 94,
    f95 = 95,
    f96 = 96,
    f97 = 97,
    f98 = 98,
    f99 = 99,
    f100 = 100,
  )
  val r2_120 = Record(
    f1 = 1,
    f2 = 2,
    f3 = 3,
    f4 = 4,
    f5 = 5,
    f6 = 6,
    f7 = 7,
    f8 = 8,
    f9 = 9,
    f10 = 10,
    f11 = 11,
    f12 = 12,
    f13 = 13,
    f14 = 14,
    f15 = 15,
    f16 = 16,
    f17 = 17,
    f18 = 18,
    f19 = 19,
    f20 = 20,
    f21 = 21,
    f22 = 22,
    f23 = 23,
    f24 = 24,
    f25 = 25,
    f26 = 26,
    f27 = 27,
    f28 = 28,
    f29 = 29,
    f30 = 30,
    f31 = 31,
    f32 = 32,
    f33 = 33,
    f34 = 34,
    f35 = 35,
    f36 = 36,
    f37 = 37,
    f38 = 38,
    f39 = 39,
    f40 = 40,
    f41 = 41,
    f42 = 42,
    f43 = 43,
    f44 = 44,
    f45 = 45,
    f46 = 46,
    f47 = 47,
    f48 = 48,
    f49 = 49,
    f50 = 50,
    f51 = 51,
    f52 = 52,
    f53 = 53,
    f54 = 54,
    f55 = 55,
    f56 = 56,
    f57 = 57,
    f58 = 58,
    f59 = 59,
    f60 = 60,
    f61 = 61,
    f62 = 62,
    f63 = 63,
    f64 = 64,
    f65 = 65,
    f66 = 66,
    f67 = 67,
    f68 = 68,
    f69 = 69,
    f70 = 70,
    f71 = 71,
    f72 = 72,
    f73 = 73,
    f74 = 74,
    f75 = 75,
    f76 = 76,
    f77 = 77,
    f78 = 78,
    f79 = 79,
    f80 = 80,
    f81 = 81,
    f82 = 82,
    f83 = 83,
    f84 = 84,
    f85 = 85,
    f86 = 86,
    f87 = 87,
    f88 = 88,
    f89 = 89,
    f90 = 90,
    f91 = 91,
    f92 = 92,
    f93 = 93,
    f94 = 94,
    f95 = 95,
    f96 = 96,
    f97 = 97,
    f98 = 98,
    f99 = 99,
    f100 = 100,
    f101 = 101,
    f102 = 102,
    f103 = 103,
    f104 = 104,
    f105 = 105,
    f106 = 106,
    f107 = 107,
    f108 = 108,
    f109 = 109,
    f110 = 110,
    f111 = 111,
    f112 = 112,
    f113 = 113,
    f114 = 114,
    f115 = 115,
    f116 = 116,
    f117 = 117,
    f118 = 118,
    f119 = 119,
    f120 = 120,
  )
}
