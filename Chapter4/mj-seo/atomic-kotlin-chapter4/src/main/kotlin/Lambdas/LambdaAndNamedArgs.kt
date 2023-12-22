import Test.eq


fun main() {
    val list = listOf(9, 11, 23, 32)
    // 람다를 이름 붙은 인자로 호출하고 싶다면, 인자 목록을 감싸는 괄호안에 위치시켜야 한다.
    list.joinToString(
        separator = " ",
        transform = { "[$it]" }
    ) eq "[9] [11] [23] [32]"
}