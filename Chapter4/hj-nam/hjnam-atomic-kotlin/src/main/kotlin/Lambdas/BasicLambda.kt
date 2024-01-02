import atomictest.eq

fun main() {
    val list = listOf(1, 2, 3, 4)
    val result = list.map({ n: Int -> "[$n]" }) // 중괄호 사이에 쓴 코드가 람다
    result eq listOf("[1]", "[2]", "[3]", "[4]")
}