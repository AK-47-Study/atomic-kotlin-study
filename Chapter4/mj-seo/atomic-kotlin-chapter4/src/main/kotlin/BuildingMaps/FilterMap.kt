import Test.eq


fun main() {
    val map = mapOf(1 to "one", 2 to "two",
        3 to "three", 4 to "four")

    /*
    *  filter(), filterKeys(), filterValues()는 모두 조건에 만족하는 새로운
    *  Map을 반환하는 함수이다.
    * */
    map.filterKeys { it % 2 == 1 } eq
            "{1=one, 3=three}"

    map.filterValues { it.contains('o') } eq
            "{1=one, 2=two, 4=four}"

    map.filter { entry ->
        entry.key % 2 == 1 &&
                entry.value.contains('o')
    } eq "{1=one}"

    map.filterValues { it == "three" } eq "{3=three}"
}