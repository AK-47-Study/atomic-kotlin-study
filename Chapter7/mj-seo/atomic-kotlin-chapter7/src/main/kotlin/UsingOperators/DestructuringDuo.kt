package usingoperators

import Test.eq
import Test.trace


class Duo(val x: Int, val y: Int) {
    // 구조 분해 연산자도 정의할 수 있다 -> 통상적으로 componentN() 함수라고 한다.
    operator fun component1(): Int {
        trace("component1()")
        return x
    }

    operator fun component2(): Int {
        trace("component2()")
        return y
    }
}

fun main() {
    val (a, b) = Duo(1, 2)
    a eq 1
    b eq 2

    trace eq "component1() component2()"
}