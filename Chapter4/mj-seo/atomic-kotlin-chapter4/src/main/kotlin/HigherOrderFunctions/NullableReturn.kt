import Test.eq


fun main() {
    val transform: (String) -> Int? =
        { s: String -> s.toIntOrNull() }

    transform("112") eq 112
    transform("abc") eq null

    val x = listOf("112", "abc")

    /*
    *  mapNotNull()은 List의 각 원소를 null이 될 수 있는 값으로 변환하고,
    *  변환 결과에서 null을 제외시킨다.
    * */
    x.mapNotNull(transform) eq "[112]"
    x.mapNotNull { it.toIntOrNull() } eq "[112]"
}