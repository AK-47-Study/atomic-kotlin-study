import Test.eq


fun main() {
    val list = listOf(1, 2, 3, 4)
    // 람다를 List<Int>에 사용 중이므로, 코틀린은 n의 타입이 Int라는 것을 알 수 있다.
    val result = list.map { n -> "[$n]" }
    result eq listOf("[1]", "[2]", "[3]", "[4]")
}