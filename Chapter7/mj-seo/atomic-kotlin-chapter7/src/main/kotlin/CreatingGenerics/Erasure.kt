package creatinggenerics


fun main() {
    val strings = listOf("a", "b", "c")
    val all: List<Any> = listOf(1, 2, "x")

    useList(strings)
    useList(all)
}

fun useList(list: List<Any>) {
    // 실행 시점에 제네릭 타입의 타입 파라미터 타입은 검사 불가하다.
//    if (list is List<String>) {}
}