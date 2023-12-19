package NumberTypes

fun main() {
    val i: Int = Int.MAX_VALUE
    // Integer의 저장 범위 초과로 Overflow가 발생한다.
    println(i+ i)
}