package destructuring

import atomictest.eq


data class Tuple(
    val i: Int,
    val d: Double,
    val s: String,
    val b: Boolean,
    val l: List<Int>,
)

fun main() {
    val tuple = Tuple(
        1, 3.14, "Mouse", false, listOf())
    val (i, d, s, b, l) = tuple

    i eq 1
    d eq 3.14
    s eq "Mouse"
    b eq false
    l eq listOf()

    /*
    *  구조 분해 선언으로 선언할 식별자 중 일부가 필요하지 않다면,
    *  이름 대신 밑줄(_)을 사용할 수 있고, 맨 뒤쪽 이름들은 아예 생략할 수 있다.
    * */
    val (_, _, animal) = tuple
    animal eq "Mouse"
}