import Test.eq


fun main() {
    val list = listOf(1, 2, 3, 4, 5)
    val value = 3
    var result = ""

    list.forEach tag@{
        result += "$it"
        // return@tag는 main()이 아니라 람다를 반환한다.
        if (it == value) return@tag
    }

    result eq "12345"
}