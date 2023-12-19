import atomictest.eq


fun main() {
    val list = listOf('a', 'b', 'c', 'd')
    // 함수의 파라미터가 람다 뿐이면 괄호를 생략할 수 있다.
    val result = list.map { "[${it.uppercase()}]" }

    result eq listOf("[A]", "[B]", "[C]", "[D]")
}