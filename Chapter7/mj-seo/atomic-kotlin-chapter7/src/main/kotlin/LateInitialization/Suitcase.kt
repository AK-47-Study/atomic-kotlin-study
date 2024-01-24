package lateinitialization

import Test.eq


class Suitcase : Bag {
    /*
    *  items를 객체 생성과 동시에 초기화하지 않는다고 해서,
    *  빈 문자열이나 Null 값으로 초기화 하는 것은 나쁜 방식이다.
    */
    private var items: String? = null
    override fun setUp() {
        items = "socks, jacket, laptop"
    }

    fun checkSocks(): Boolean =
        items?.contains("socks") ?: false
}

fun main() {
    val suitcase = Suitcase()
    suitcase.setUp()
    suitcase.checkSocks() eq true
}