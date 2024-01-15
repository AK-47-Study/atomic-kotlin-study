package extensionlambdas

import Test.eq

// va는 일반 람다로 정의된 함수다.
val va: (String, Int) -> String = { str, n ->
    str.repeat(n) + str.repeat(n)
}

// vb는 String 파라미터를 괄호 밖으로 옮겨서 확장 함수 구문을 사용했다.
val vb: String.(Int) -> String = {
    this.repeat(it) + repeat(it)
}

fun main() {
    va("Vanbo", 2) eq "VanboVanboVanboVanbo"
    "Vanbo".vb(2) eq "VanboVanboVanboVanbo"
    vb("Vanbo", 2) eq "VanboVanboVanboVanbo"

    // 에러! 컴파일 되지 않는다.
//    "Vanbo".va(2)
}