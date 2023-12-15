import atomictest.eq


fun getList(): List<Int> {
    return mutableListOf(1, 2, 3)
}

fun main() {
    // getList()는 읽기 전용 List를 만든다
    val list = getList()

    /*
    *  mutableListOf 함수로 List를 생성했지만, list에 상태 변경 함수가 없다.
    *  -> return 하면서 List<Int>로 변경 되었기 떄문에 List는 읽기 전용이므로 변경할 수 없다.
    * */
    // list += 3 -> 오류

    list eq listOf(1, 2, 3)
}