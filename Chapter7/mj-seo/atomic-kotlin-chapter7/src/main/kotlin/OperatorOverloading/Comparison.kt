package operatoroverloading

import Test.eq

// compareTo()를 정의하면 비교 연산자를 사용할 수 있다.
operator fun E.compareTo(e: E): Int =
    v.compareTo(e.v)

fun main() {
    val a = E(2)
    val b = E(3)

    (a < b) eq true
    (a > b) eq false
    (a <= b) eq true
    (a >= b) eq false
}