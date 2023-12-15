import atomictest.eq


fun main() {
    /*
    *  first와 second는 메모리에 있는 같은 객체를 참조한다.
    *  -> first 참조를 통해 List를 변경하면 이 변경을 second 참조를 통해 관찰할 수 있다.
    * */
    val first = mutableListOf(1)
    val second: List<Int> = first

    second eq listOf(1)
    first += 2

    // second에서도 변경된 내용을 볼 수 있다.
    second eq listOf(1, 2)
}