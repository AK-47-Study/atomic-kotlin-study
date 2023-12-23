import Test.eq


fun main() {
    val list = listOf(1, 2, 3, 4, 5)
    val value = 3

    var result = ""

    list.forEach {
        result += "$it"
        if (it == value) {
            result eq "123"
            // 레이블이 붙은 return을 사용하면 main() 함수를 끝내지 않는다. -> 레이블인 forEach 까지만 반환한다.
            return@forEach
        }
    }

    result eq "12345"
}