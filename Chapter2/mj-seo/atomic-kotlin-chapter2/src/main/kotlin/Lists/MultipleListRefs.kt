import atomictest.eq


fun main() {
    val first = mutableListOf(1)
    val second: List<Int> = first
    second eq listOf(1)

    first += 2

    /*
    *  second는 변경될 수 없는 List지만 first를 통하면 List의 내부를 변경할 수 있다.
    *  -> second는 List<Int> 타입으로 명시되어 원소를 추가할 수 없지만,
    *  원본 객체는 first의 MutableList 참조를 가지므로 first에 원소를 추가하면 second 또한
    *  원소가 추가된다.
    * */
    second eq listOf(1, 2)
}