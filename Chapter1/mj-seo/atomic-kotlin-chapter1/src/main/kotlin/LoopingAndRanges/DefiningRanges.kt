package LoopingAndRanges

fun main() {
    /*
    *  .. 으로 범위를 표현하면 양 끝 값을 포함한 범위를 만든다.
    *  until로 범위를 표현하면 until 다음에 오는 값을 제외한 범위를 만든다.
    * */
    val range1 = 1..10
    val range2 = 0 until 10

    println(range1)
    println(range2)
}