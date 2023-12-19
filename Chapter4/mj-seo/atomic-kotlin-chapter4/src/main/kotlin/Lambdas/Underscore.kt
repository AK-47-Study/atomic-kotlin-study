import atomictest.eq


fun main() {
    val list = listOf('a', 'b', 'c')
    // 특정 인자를 사용하지 않을 때, 밑줄을 쓰면 람다가 인자를 사용하지 않는다는 컴파일러 경고를 무시할 수 있다.
    list.mapIndexed { index, _ ->
        "[$index]" } eq listOf("[0]", "[1]", "[2]")
}