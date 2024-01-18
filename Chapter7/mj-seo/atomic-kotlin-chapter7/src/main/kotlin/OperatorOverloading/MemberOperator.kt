package operatoroverloading

import Test.eq


data class Num2(private val n: Int) {
    operator fun plus(rval: Num2) =
        Num2(n + rval.n)
}

// 연산자를 확장 함수로 정의하면 private 멤버에 접근이 불가능하다.
//operator fun Num2.minus(rval: Num2) =
//    Num2(n - rval.n)

fun main() {
    Num2(4) + Num2(5) eq Num2(9)
}