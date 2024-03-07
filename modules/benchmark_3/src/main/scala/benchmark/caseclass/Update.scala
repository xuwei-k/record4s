package benchmark
package caseclass

import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.*

@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 10, time = 200, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 20, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@State(Scope.Thread)
class Update {
  // Use `var` to prevent constant folding
  var r_1 = Record1(
    f1 = 1,
  )
  var r_20 = Record20(
    f1  = 1,
    f2  = 2,
    f3  = 3,
    f4  = 4,
    f5  = 5,
    f6  = 6,
    f7  = 7,
    f8  = 8,
    f9  = 9,
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
  var r_40 = Record40(
    f1  = 1,
    f2  = 2,
    f3  = 3,
    f4  = 4,
    f5  = 5,
    f6  = 6,
    f7  = 7,
    f8  = 8,
    f9  = 9,
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
  var r_60 = Record60(
    f1  = 1,
    f2  = 2,
    f3  = 3,
    f4  = 4,
    f5  = 5,
    f6  = 6,
    f7  = 7,
    f8  = 8,
    f9  = 9,
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
  var r_80 = Record80(
    f1  = 1,
    f2  = 2,
    f3  = 3,
    f4  = 4,
    f5  = 5,
    f6  = 6,
    f7  = 7,
    f8  = 8,
    f9  = 9,
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
  var r_100 = Record100(
    f1   = 1,
    f2   = 2,
    f3   = 3,
    f4   = 4,
    f5   = 5,
    f6   = 6,
    f7   = 7,
    f8   = 8,
    f9   = 9,
    f10  = 10,
    f11  = 11,
    f12  = 12,
    f13  = 13,
    f14  = 14,
    f15  = 15,
    f16  = 16,
    f17  = 17,
    f18  = 18,
    f19  = 19,
    f20  = 20,
    f21  = 21,
    f22  = 22,
    f23  = 23,
    f24  = 24,
    f25  = 25,
    f26  = 26,
    f27  = 27,
    f28  = 28,
    f29  = 29,
    f30  = 30,
    f31  = 31,
    f32  = 32,
    f33  = 33,
    f34  = 34,
    f35  = 35,
    f36  = 36,
    f37  = 37,
    f38  = 38,
    f39  = 39,
    f40  = 40,
    f41  = 41,
    f42  = 42,
    f43  = 43,
    f44  = 44,
    f45  = 45,
    f46  = 46,
    f47  = 47,
    f48  = 48,
    f49  = 49,
    f50  = 50,
    f51  = 51,
    f52  = 52,
    f53  = 53,
    f54  = 54,
    f55  = 55,
    f56  = 56,
    f57  = 57,
    f58  = 58,
    f59  = 59,
    f60  = 60,
    f61  = 61,
    f62  = 62,
    f63  = 63,
    f64  = 64,
    f65  = 65,
    f66  = 66,
    f67  = 67,
    f68  = 68,
    f69  = 69,
    f70  = 70,
    f71  = 71,
    f72  = 72,
    f73  = 73,
    f74  = 74,
    f75  = 75,
    f76  = 76,
    f77  = 77,
    f78  = 78,
    f79  = 79,
    f80  = 80,
    f81  = 81,
    f82  = 82,
    f83  = 83,
    f84  = 84,
    f85  = 85,
    f86  = 86,
    f87  = 87,
    f88  = 88,
    f89  = 89,
    f90  = 90,
    f91  = 91,
    f92  = 92,
    f93  = 93,
    f94  = 94,
    f95  = 95,
    f96  = 96,
    f97  = 97,
    f98  = 98,
    f99  = 99,
    f100 = 100,
  )
  var r_120 = Record120(
    f1   = 1,
    f2   = 2,
    f3   = 3,
    f4   = 4,
    f5   = 5,
    f6   = 6,
    f7   = 7,
    f8   = 8,
    f9   = 9,
    f10  = 10,
    f11  = 11,
    f12  = 12,
    f13  = 13,
    f14  = 14,
    f15  = 15,
    f16  = 16,
    f17  = 17,
    f18  = 18,
    f19  = 19,
    f20  = 20,
    f21  = 21,
    f22  = 22,
    f23  = 23,
    f24  = 24,
    f25  = 25,
    f26  = 26,
    f27  = 27,
    f28  = 28,
    f29  = 29,
    f30  = 30,
    f31  = 31,
    f32  = 32,
    f33  = 33,
    f34  = 34,
    f35  = 35,
    f36  = 36,
    f37  = 37,
    f38  = 38,
    f39  = 39,
    f40  = 40,
    f41  = 41,
    f42  = 42,
    f43  = 43,
    f44  = 44,
    f45  = 45,
    f46  = 46,
    f47  = 47,
    f48  = 48,
    f49  = 49,
    f50  = 50,
    f51  = 51,
    f52  = 52,
    f53  = 53,
    f54  = 54,
    f55  = 55,
    f56  = 56,
    f57  = 57,
    f58  = 58,
    f59  = 59,
    f60  = 60,
    f61  = 61,
    f62  = 62,
    f63  = 63,
    f64  = 64,
    f65  = 65,
    f66  = 66,
    f67  = 67,
    f68  = 68,
    f69  = 69,
    f70  = 70,
    f71  = 71,
    f72  = 72,
    f73  = 73,
    f74  = 74,
    f75  = 75,
    f76  = 76,
    f77  = 77,
    f78  = 78,
    f79  = 79,
    f80  = 80,
    f81  = 81,
    f82  = 82,
    f83  = 83,
    f84  = 84,
    f85  = 85,
    f86  = 86,
    f87  = 87,
    f88  = 88,
    f89  = 89,
    f90  = 90,
    f91  = 91,
    f92  = 92,
    f93  = 93,
    f94  = 94,
    f95  = 95,
    f96  = 96,
    f97  = 97,
    f98  = 98,
    f99  = 99,
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
  var r_140 = Record140(
    f1   = 1,
    f2   = 2,
    f3   = 3,
    f4   = 4,
    f5   = 5,
    f6   = 6,
    f7   = 7,
    f8   = 8,
    f9   = 9,
    f10  = 10,
    f11  = 11,
    f12  = 12,
    f13  = 13,
    f14  = 14,
    f15  = 15,
    f16  = 16,
    f17  = 17,
    f18  = 18,
    f19  = 19,
    f20  = 20,
    f21  = 21,
    f22  = 22,
    f23  = 23,
    f24  = 24,
    f25  = 25,
    f26  = 26,
    f27  = 27,
    f28  = 28,
    f29  = 29,
    f30  = 30,
    f31  = 31,
    f32  = 32,
    f33  = 33,
    f34  = 34,
    f35  = 35,
    f36  = 36,
    f37  = 37,
    f38  = 38,
    f39  = 39,
    f40  = 40,
    f41  = 41,
    f42  = 42,
    f43  = 43,
    f44  = 44,
    f45  = 45,
    f46  = 46,
    f47  = 47,
    f48  = 48,
    f49  = 49,
    f50  = 50,
    f51  = 51,
    f52  = 52,
    f53  = 53,
    f54  = 54,
    f55  = 55,
    f56  = 56,
    f57  = 57,
    f58  = 58,
    f59  = 59,
    f60  = 60,
    f61  = 61,
    f62  = 62,
    f63  = 63,
    f64  = 64,
    f65  = 65,
    f66  = 66,
    f67  = 67,
    f68  = 68,
    f69  = 69,
    f70  = 70,
    f71  = 71,
    f72  = 72,
    f73  = 73,
    f74  = 74,
    f75  = 75,
    f76  = 76,
    f77  = 77,
    f78  = 78,
    f79  = 79,
    f80  = 80,
    f81  = 81,
    f82  = 82,
    f83  = 83,
    f84  = 84,
    f85  = 85,
    f86  = 86,
    f87  = 87,
    f88  = 88,
    f89  = 89,
    f90  = 90,
    f91  = 91,
    f92  = 92,
    f93  = 93,
    f94  = 94,
    f95  = 95,
    f96  = 96,
    f97  = 97,
    f98  = 98,
    f99  = 99,
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
    f121 = 121,
    f122 = 122,
    f123 = 123,
    f124 = 124,
    f125 = 125,
    f126 = 126,
    f127 = 127,
    f128 = 128,
    f129 = 129,
    f130 = 130,
    f131 = 131,
    f132 = 132,
    f133 = 133,
    f134 = 134,
    f135 = 135,
    f136 = 136,
    f137 = 137,
    f138 = 138,
    f139 = 139,
    f140 = 140,
  )
  var r_160 = Record160(
    f1   = 1,
    f2   = 2,
    f3   = 3,
    f4   = 4,
    f5   = 5,
    f6   = 6,
    f7   = 7,
    f8   = 8,
    f9   = 9,
    f10  = 10,
    f11  = 11,
    f12  = 12,
    f13  = 13,
    f14  = 14,
    f15  = 15,
    f16  = 16,
    f17  = 17,
    f18  = 18,
    f19  = 19,
    f20  = 20,
    f21  = 21,
    f22  = 22,
    f23  = 23,
    f24  = 24,
    f25  = 25,
    f26  = 26,
    f27  = 27,
    f28  = 28,
    f29  = 29,
    f30  = 30,
    f31  = 31,
    f32  = 32,
    f33  = 33,
    f34  = 34,
    f35  = 35,
    f36  = 36,
    f37  = 37,
    f38  = 38,
    f39  = 39,
    f40  = 40,
    f41  = 41,
    f42  = 42,
    f43  = 43,
    f44  = 44,
    f45  = 45,
    f46  = 46,
    f47  = 47,
    f48  = 48,
    f49  = 49,
    f50  = 50,
    f51  = 51,
    f52  = 52,
    f53  = 53,
    f54  = 54,
    f55  = 55,
    f56  = 56,
    f57  = 57,
    f58  = 58,
    f59  = 59,
    f60  = 60,
    f61  = 61,
    f62  = 62,
    f63  = 63,
    f64  = 64,
    f65  = 65,
    f66  = 66,
    f67  = 67,
    f68  = 68,
    f69  = 69,
    f70  = 70,
    f71  = 71,
    f72  = 72,
    f73  = 73,
    f74  = 74,
    f75  = 75,
    f76  = 76,
    f77  = 77,
    f78  = 78,
    f79  = 79,
    f80  = 80,
    f81  = 81,
    f82  = 82,
    f83  = 83,
    f84  = 84,
    f85  = 85,
    f86  = 86,
    f87  = 87,
    f88  = 88,
    f89  = 89,
    f90  = 90,
    f91  = 91,
    f92  = 92,
    f93  = 93,
    f94  = 94,
    f95  = 95,
    f96  = 96,
    f97  = 97,
    f98  = 98,
    f99  = 99,
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
    f121 = 121,
    f122 = 122,
    f123 = 123,
    f124 = 124,
    f125 = 125,
    f126 = 126,
    f127 = 127,
    f128 = 128,
    f129 = 129,
    f130 = 130,
    f131 = 131,
    f132 = 132,
    f133 = 133,
    f134 = 134,
    f135 = 135,
    f136 = 136,
    f137 = 137,
    f138 = 138,
    f139 = 139,
    f140 = 140,
    f141 = 141,
    f142 = 142,
    f143 = 143,
    f144 = 144,
    f145 = 145,
    f146 = 146,
    f147 = 147,
    f148 = 148,
    f149 = 149,
    f150 = 150,
    f151 = 151,
    f152 = 152,
    f153 = 153,
    f154 = 154,
    f155 = 155,
    f156 = 156,
    f157 = 157,
    f158 = 158,
    f159 = 159,
    f160 = 160,
  )
  var r_180 = Record180(
    f1   = 1,
    f2   = 2,
    f3   = 3,
    f4   = 4,
    f5   = 5,
    f6   = 6,
    f7   = 7,
    f8   = 8,
    f9   = 9,
    f10  = 10,
    f11  = 11,
    f12  = 12,
    f13  = 13,
    f14  = 14,
    f15  = 15,
    f16  = 16,
    f17  = 17,
    f18  = 18,
    f19  = 19,
    f20  = 20,
    f21  = 21,
    f22  = 22,
    f23  = 23,
    f24  = 24,
    f25  = 25,
    f26  = 26,
    f27  = 27,
    f28  = 28,
    f29  = 29,
    f30  = 30,
    f31  = 31,
    f32  = 32,
    f33  = 33,
    f34  = 34,
    f35  = 35,
    f36  = 36,
    f37  = 37,
    f38  = 38,
    f39  = 39,
    f40  = 40,
    f41  = 41,
    f42  = 42,
    f43  = 43,
    f44  = 44,
    f45  = 45,
    f46  = 46,
    f47  = 47,
    f48  = 48,
    f49  = 49,
    f50  = 50,
    f51  = 51,
    f52  = 52,
    f53  = 53,
    f54  = 54,
    f55  = 55,
    f56  = 56,
    f57  = 57,
    f58  = 58,
    f59  = 59,
    f60  = 60,
    f61  = 61,
    f62  = 62,
    f63  = 63,
    f64  = 64,
    f65  = 65,
    f66  = 66,
    f67  = 67,
    f68  = 68,
    f69  = 69,
    f70  = 70,
    f71  = 71,
    f72  = 72,
    f73  = 73,
    f74  = 74,
    f75  = 75,
    f76  = 76,
    f77  = 77,
    f78  = 78,
    f79  = 79,
    f80  = 80,
    f81  = 81,
    f82  = 82,
    f83  = 83,
    f84  = 84,
    f85  = 85,
    f86  = 86,
    f87  = 87,
    f88  = 88,
    f89  = 89,
    f90  = 90,
    f91  = 91,
    f92  = 92,
    f93  = 93,
    f94  = 94,
    f95  = 95,
    f96  = 96,
    f97  = 97,
    f98  = 98,
    f99  = 99,
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
    f121 = 121,
    f122 = 122,
    f123 = 123,
    f124 = 124,
    f125 = 125,
    f126 = 126,
    f127 = 127,
    f128 = 128,
    f129 = 129,
    f130 = 130,
    f131 = 131,
    f132 = 132,
    f133 = 133,
    f134 = 134,
    f135 = 135,
    f136 = 136,
    f137 = 137,
    f138 = 138,
    f139 = 139,
    f140 = 140,
    f141 = 141,
    f142 = 142,
    f143 = 143,
    f144 = 144,
    f145 = 145,
    f146 = 146,
    f147 = 147,
    f148 = 148,
    f149 = 149,
    f150 = 150,
    f151 = 151,
    f152 = 152,
    f153 = 153,
    f154 = 154,
    f155 = 155,
    f156 = 156,
    f157 = 157,
    f158 = 158,
    f159 = 159,
    f160 = 160,
    f161 = 161,
    f162 = 162,
    f163 = 163,
    f164 = 164,
    f165 = 165,
    f166 = 166,
    f167 = 167,
    f168 = 168,
    f169 = 169,
    f170 = 170,
    f171 = 171,
    f172 = 172,
    f173 = 173,
    f174 = 174,
    f175 = 175,
    f176 = 176,
    f177 = 177,
    f178 = 178,
    f179 = 179,
    f180 = 180,
  )
  var r_200 = Record200(
    f1   = 1,
    f2   = 2,
    f3   = 3,
    f4   = 4,
    f5   = 5,
    f6   = 6,
    f7   = 7,
    f8   = 8,
    f9   = 9,
    f10  = 10,
    f11  = 11,
    f12  = 12,
    f13  = 13,
    f14  = 14,
    f15  = 15,
    f16  = 16,
    f17  = 17,
    f18  = 18,
    f19  = 19,
    f20  = 20,
    f21  = 21,
    f22  = 22,
    f23  = 23,
    f24  = 24,
    f25  = 25,
    f26  = 26,
    f27  = 27,
    f28  = 28,
    f29  = 29,
    f30  = 30,
    f31  = 31,
    f32  = 32,
    f33  = 33,
    f34  = 34,
    f35  = 35,
    f36  = 36,
    f37  = 37,
    f38  = 38,
    f39  = 39,
    f40  = 40,
    f41  = 41,
    f42  = 42,
    f43  = 43,
    f44  = 44,
    f45  = 45,
    f46  = 46,
    f47  = 47,
    f48  = 48,
    f49  = 49,
    f50  = 50,
    f51  = 51,
    f52  = 52,
    f53  = 53,
    f54  = 54,
    f55  = 55,
    f56  = 56,
    f57  = 57,
    f58  = 58,
    f59  = 59,
    f60  = 60,
    f61  = 61,
    f62  = 62,
    f63  = 63,
    f64  = 64,
    f65  = 65,
    f66  = 66,
    f67  = 67,
    f68  = 68,
    f69  = 69,
    f70  = 70,
    f71  = 71,
    f72  = 72,
    f73  = 73,
    f74  = 74,
    f75  = 75,
    f76  = 76,
    f77  = 77,
    f78  = 78,
    f79  = 79,
    f80  = 80,
    f81  = 81,
    f82  = 82,
    f83  = 83,
    f84  = 84,
    f85  = 85,
    f86  = 86,
    f87  = 87,
    f88  = 88,
    f89  = 89,
    f90  = 90,
    f91  = 91,
    f92  = 92,
    f93  = 93,
    f94  = 94,
    f95  = 95,
    f96  = 96,
    f97  = 97,
    f98  = 98,
    f99  = 99,
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
    f121 = 121,
    f122 = 122,
    f123 = 123,
    f124 = 124,
    f125 = 125,
    f126 = 126,
    f127 = 127,
    f128 = 128,
    f129 = 129,
    f130 = 130,
    f131 = 131,
    f132 = 132,
    f133 = 133,
    f134 = 134,
    f135 = 135,
    f136 = 136,
    f137 = 137,
    f138 = 138,
    f139 = 139,
    f140 = 140,
    f141 = 141,
    f142 = 142,
    f143 = 143,
    f144 = 144,
    f145 = 145,
    f146 = 146,
    f147 = 147,
    f148 = 148,
    f149 = 149,
    f150 = 150,
    f151 = 151,
    f152 = 152,
    f153 = 153,
    f154 = 154,
    f155 = 155,
    f156 = 156,
    f157 = 157,
    f158 = 158,
    f159 = 159,
    f160 = 160,
    f161 = 161,
    f162 = 162,
    f163 = 163,
    f164 = 164,
    f165 = 165,
    f166 = 166,
    f167 = 167,
    f168 = 168,
    f169 = 169,
    f170 = 170,
    f171 = 171,
    f172 = 172,
    f173 = 173,
    f174 = 174,
    f175 = 175,
    f176 = 176,
    f177 = 177,
    f178 = 178,
    f179 = 179,
    f180 = 180,
    f181 = 181,
    f182 = 182,
    f183 = 183,
    f184 = 184,
    f185 = 185,
    f186 = 186,
    f187 = 187,
    f188 = 188,
    f189 = 189,
    f190 = 190,
    f191 = 191,
    f192 = 192,
    f193 = 193,
    f194 = 194,
    f195 = 195,
    f196 = 196,
    f197 = 197,
    f198 = 198,
    f199 = 199,
    f200 = 200,
  )
  var r_220 = Record220(
    f1   = 1,
    f2   = 2,
    f3   = 3,
    f4   = 4,
    f5   = 5,
    f6   = 6,
    f7   = 7,
    f8   = 8,
    f9   = 9,
    f10  = 10,
    f11  = 11,
    f12  = 12,
    f13  = 13,
    f14  = 14,
    f15  = 15,
    f16  = 16,
    f17  = 17,
    f18  = 18,
    f19  = 19,
    f20  = 20,
    f21  = 21,
    f22  = 22,
    f23  = 23,
    f24  = 24,
    f25  = 25,
    f26  = 26,
    f27  = 27,
    f28  = 28,
    f29  = 29,
    f30  = 30,
    f31  = 31,
    f32  = 32,
    f33  = 33,
    f34  = 34,
    f35  = 35,
    f36  = 36,
    f37  = 37,
    f38  = 38,
    f39  = 39,
    f40  = 40,
    f41  = 41,
    f42  = 42,
    f43  = 43,
    f44  = 44,
    f45  = 45,
    f46  = 46,
    f47  = 47,
    f48  = 48,
    f49  = 49,
    f50  = 50,
    f51  = 51,
    f52  = 52,
    f53  = 53,
    f54  = 54,
    f55  = 55,
    f56  = 56,
    f57  = 57,
    f58  = 58,
    f59  = 59,
    f60  = 60,
    f61  = 61,
    f62  = 62,
    f63  = 63,
    f64  = 64,
    f65  = 65,
    f66  = 66,
    f67  = 67,
    f68  = 68,
    f69  = 69,
    f70  = 70,
    f71  = 71,
    f72  = 72,
    f73  = 73,
    f74  = 74,
    f75  = 75,
    f76  = 76,
    f77  = 77,
    f78  = 78,
    f79  = 79,
    f80  = 80,
    f81  = 81,
    f82  = 82,
    f83  = 83,
    f84  = 84,
    f85  = 85,
    f86  = 86,
    f87  = 87,
    f88  = 88,
    f89  = 89,
    f90  = 90,
    f91  = 91,
    f92  = 92,
    f93  = 93,
    f94  = 94,
    f95  = 95,
    f96  = 96,
    f97  = 97,
    f98  = 98,
    f99  = 99,
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
    f121 = 121,
    f122 = 122,
    f123 = 123,
    f124 = 124,
    f125 = 125,
    f126 = 126,
    f127 = 127,
    f128 = 128,
    f129 = 129,
    f130 = 130,
    f131 = 131,
    f132 = 132,
    f133 = 133,
    f134 = 134,
    f135 = 135,
    f136 = 136,
    f137 = 137,
    f138 = 138,
    f139 = 139,
    f140 = 140,
    f141 = 141,
    f142 = 142,
    f143 = 143,
    f144 = 144,
    f145 = 145,
    f146 = 146,
    f147 = 147,
    f148 = 148,
    f149 = 149,
    f150 = 150,
    f151 = 151,
    f152 = 152,
    f153 = 153,
    f154 = 154,
    f155 = 155,
    f156 = 156,
    f157 = 157,
    f158 = 158,
    f159 = 159,
    f160 = 160,
    f161 = 161,
    f162 = 162,
    f163 = 163,
    f164 = 164,
    f165 = 165,
    f166 = 166,
    f167 = 167,
    f168 = 168,
    f169 = 169,
    f170 = 170,
    f171 = 171,
    f172 = 172,
    f173 = 173,
    f174 = 174,
    f175 = 175,
    f176 = 176,
    f177 = 177,
    f178 = 178,
    f179 = 179,
    f180 = 180,
    f181 = 181,
    f182 = 182,
    f183 = 183,
    f184 = 184,
    f185 = 185,
    f186 = 186,
    f187 = 187,
    f188 = 188,
    f189 = 189,
    f190 = 190,
    f191 = 191,
    f192 = 192,
    f193 = 193,
    f194 = 194,
    f195 = 195,
    f196 = 196,
    f197 = 197,
    f198 = 198,
    f199 = 199,
    f200 = 200,
    f201 = 201,
    f202 = 202,
    f203 = 203,
    f204 = 204,
    f205 = 205,
    f206 = 206,
    f207 = 207,
    f208 = 208,
    f209 = 209,
    f210 = 210,
    f211 = 211,
    f212 = 212,
    f213 = 213,
    f214 = 214,
    f215 = 215,
    f216 = 216,
    f217 = 217,
    f218 = 218,
    f219 = 219,
    f220 = 220,
  )
  var r_240 = Record240(
    f1   = 1,
    f2   = 2,
    f3   = 3,
    f4   = 4,
    f5   = 5,
    f6   = 6,
    f7   = 7,
    f8   = 8,
    f9   = 9,
    f10  = 10,
    f11  = 11,
    f12  = 12,
    f13  = 13,
    f14  = 14,
    f15  = 15,
    f16  = 16,
    f17  = 17,
    f18  = 18,
    f19  = 19,
    f20  = 20,
    f21  = 21,
    f22  = 22,
    f23  = 23,
    f24  = 24,
    f25  = 25,
    f26  = 26,
    f27  = 27,
    f28  = 28,
    f29  = 29,
    f30  = 30,
    f31  = 31,
    f32  = 32,
    f33  = 33,
    f34  = 34,
    f35  = 35,
    f36  = 36,
    f37  = 37,
    f38  = 38,
    f39  = 39,
    f40  = 40,
    f41  = 41,
    f42  = 42,
    f43  = 43,
    f44  = 44,
    f45  = 45,
    f46  = 46,
    f47  = 47,
    f48  = 48,
    f49  = 49,
    f50  = 50,
    f51  = 51,
    f52  = 52,
    f53  = 53,
    f54  = 54,
    f55  = 55,
    f56  = 56,
    f57  = 57,
    f58  = 58,
    f59  = 59,
    f60  = 60,
    f61  = 61,
    f62  = 62,
    f63  = 63,
    f64  = 64,
    f65  = 65,
    f66  = 66,
    f67  = 67,
    f68  = 68,
    f69  = 69,
    f70  = 70,
    f71  = 71,
    f72  = 72,
    f73  = 73,
    f74  = 74,
    f75  = 75,
    f76  = 76,
    f77  = 77,
    f78  = 78,
    f79  = 79,
    f80  = 80,
    f81  = 81,
    f82  = 82,
    f83  = 83,
    f84  = 84,
    f85  = 85,
    f86  = 86,
    f87  = 87,
    f88  = 88,
    f89  = 89,
    f90  = 90,
    f91  = 91,
    f92  = 92,
    f93  = 93,
    f94  = 94,
    f95  = 95,
    f96  = 96,
    f97  = 97,
    f98  = 98,
    f99  = 99,
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
    f121 = 121,
    f122 = 122,
    f123 = 123,
    f124 = 124,
    f125 = 125,
    f126 = 126,
    f127 = 127,
    f128 = 128,
    f129 = 129,
    f130 = 130,
    f131 = 131,
    f132 = 132,
    f133 = 133,
    f134 = 134,
    f135 = 135,
    f136 = 136,
    f137 = 137,
    f138 = 138,
    f139 = 139,
    f140 = 140,
    f141 = 141,
    f142 = 142,
    f143 = 143,
    f144 = 144,
    f145 = 145,
    f146 = 146,
    f147 = 147,
    f148 = 148,
    f149 = 149,
    f150 = 150,
    f151 = 151,
    f152 = 152,
    f153 = 153,
    f154 = 154,
    f155 = 155,
    f156 = 156,
    f157 = 157,
    f158 = 158,
    f159 = 159,
    f160 = 160,
    f161 = 161,
    f162 = 162,
    f163 = 163,
    f164 = 164,
    f165 = 165,
    f166 = 166,
    f167 = 167,
    f168 = 168,
    f169 = 169,
    f170 = 170,
    f171 = 171,
    f172 = 172,
    f173 = 173,
    f174 = 174,
    f175 = 175,
    f176 = 176,
    f177 = 177,
    f178 = 178,
    f179 = 179,
    f180 = 180,
    f181 = 181,
    f182 = 182,
    f183 = 183,
    f184 = 184,
    f185 = 185,
    f186 = 186,
    f187 = 187,
    f188 = 188,
    f189 = 189,
    f190 = 190,
    f191 = 191,
    f192 = 192,
    f193 = 193,
    f194 = 194,
    f195 = 195,
    f196 = 196,
    f197 = 197,
    f198 = 198,
    f199 = 199,
    f200 = 200,
    f201 = 201,
    f202 = 202,
    f203 = 203,
    f204 = 204,
    f205 = 205,
    f206 = 206,
    f207 = 207,
    f208 = 208,
    f209 = 209,
    f210 = 210,
    f211 = 211,
    f212 = 212,
    f213 = 213,
    f214 = 214,
    f215 = 215,
    f216 = 216,
    f217 = 217,
    f218 = 218,
    f219 = 219,
    f220 = 220,
    f221 = 221,
    f222 = 222,
    f223 = 223,
    f224 = 224,
    f225 = 225,
    f226 = 226,
    f227 = 227,
    f228 = 228,
    f229 = 229,
    f230 = 230,
    f231 = 231,
    f232 = 232,
    f233 = 233,
    f234 = 234,
    f235 = 235,
    f236 = 236,
    f237 = 237,
    f238 = 238,
    f239 = 239,
    f240 = 240,
  )

  @Benchmark
  def update_f1 = r_1.copy(f1 = r_1.f1 + 1)

  @Benchmark
  def update_f20 = r_20.copy(f20 = r_20.f20 + 1)

  @Benchmark
  def update_f40 = r_40.copy(f40 = r_40.f40 + 1)

  @Benchmark
  def update_f60 = r_60.copy(f60 = r_60.f60 + 1)

  @Benchmark
  def update_f80 = r_80.copy(f80 = r_80.f80 + 1)

  @Benchmark
  def update_f100 = r_100.copy(f100 = r_100.f100 + 1)

  @Benchmark
  def update_f120 = r_120.copy(f120 = r_120.f120 + 1)

  @Benchmark
  def update_f140 = r_140.copy(f140 = r_140.f140 + 1)

  @Benchmark
  def update_f160 = r_160.copy(f160 = r_160.f160 + 1)

  @Benchmark
  def update_f180 = r_180.copy(f180 = r_180.f180 + 1)

  @Benchmark
  def update_f200 = r_200.copy(f200 = r_200.f200 + 1)

  @Benchmark
  def update_f220 = r_220.copy(f220 = r_220.f220 + 1)

  @Benchmark
  def update_f240 = r_240.copy(f240 = r_240.f240 + 1)
}
