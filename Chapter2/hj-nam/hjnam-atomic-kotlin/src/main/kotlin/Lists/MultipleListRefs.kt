import atomictest.eq

fun main() {
    val first = mutableListOf(1)
    val second: List<Int> = first  // 에일리어싱
    second eq listOf(1)

    first += 2
    // second도 first에 의해 변경된 내용을 가리킴
    second eq listOf(1, 2)

}