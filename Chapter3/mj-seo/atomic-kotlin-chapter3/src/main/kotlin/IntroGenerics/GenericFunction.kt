package introgenerics

import atomictest.eq


/*
*  제네릭스를 이용해 정의한 항등함수
*  -> 제네릭 함수를 정의하는 방법은 Java와 그 규칙이 같다.
* */
fun <T> identity(arg: T): T = arg

fun main() {
    identity("Yellow") eq "Yellow"
    identity(1) eq 1

    val d: Dog = identity(Dog())
    d.bark() eq "Ruff!"
}