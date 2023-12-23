import Test.eq


fun main() {
    val list = listOf(
        listOf(1, 2),
        listOf(4, 5),
        listOf(7, 8)
    )

    /*
    *  flatten() 함수는 List<List<?>>를 List<?>로 반환한다.
    * */
    list.flatten() eq "[1, 2, 4, 5, 7, 8]"
}