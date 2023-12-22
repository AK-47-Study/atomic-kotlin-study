import Test.eq


fun main() {
    val list = listOf(1, 5, 7, 10)
    var sum = 0
    val divider = 5

    list.filter { it % divider == 0 }
        .forEach { sum += it }

    // 람다는 포획한 요소를 읽거나, 변경할 수 있다.
    sum eq 15
}