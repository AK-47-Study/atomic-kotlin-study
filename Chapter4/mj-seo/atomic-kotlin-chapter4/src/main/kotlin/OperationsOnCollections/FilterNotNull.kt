import Test.eq


fun main() {
    val list = listOf(1, 2, null)
    // filterNotNull()은 null을 제외한 원소들로 이루어진 새 List를 돌려준다.
    list.filterNotNull() eq "[1, 2]"
}