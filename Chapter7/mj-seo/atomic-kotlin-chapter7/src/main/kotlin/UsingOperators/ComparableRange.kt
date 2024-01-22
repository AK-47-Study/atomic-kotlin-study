package usingoperators

import Test.eq


class F(private val i : Int): Comparable<F> {
    override fun compareTo(other: F) =
        i.compareTo(other.i)
}

fun main() {
    /*
    *  Comparable 인터페이스를 구현하면 정렬이 가능해지고, .. 연산자를 오버로드 할 필요 없이 범위 연산을 사용할 수 있다.
    *  -> 제어할 수 없는 클래스가 아니라면, Comparable을 구현하는 쪽을 선택하는 것이 좋다.
    */
    val range = F(1)..F(7)
    (F(3) in range) eq true
    (F(9) in range) eq false
}