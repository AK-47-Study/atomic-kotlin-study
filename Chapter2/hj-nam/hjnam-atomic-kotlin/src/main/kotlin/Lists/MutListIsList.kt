package lists
import atomictest.eq

fun getList(): List<Int> {
    return mutableListOf(1, 2, 3)
}

fun main() {
    // getList()는 읽기 전용 리스트를 만듦
    val list = getList()
    // list += 3 // 오류
    list eq listOf(1, 2, 3)
}