import atomictest.eq


fun main() {
    val list = listOf(1, 5, 7, 10)
    val divider = 5

    /*
    *  람다가 가변 변수 sum을 포획할 수 있지만,
    *  환경의 상태를 변경하지 않는 형태로 코드를 변경할 수 있다.
    * */
    list.filter { it % divider == 0 }
        .sum() eq 15
}