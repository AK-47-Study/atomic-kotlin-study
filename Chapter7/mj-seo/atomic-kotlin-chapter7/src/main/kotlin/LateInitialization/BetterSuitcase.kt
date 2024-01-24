package lateinitialization

import Test.eq


class BetterSuitcase : Bag {
    /*
    *  lateinit은 var 프로퍼티에만 적용 가능하다.
    *  -> 프로퍼티의 타입은 Nullable 타입이 아니여야 한다.
    *  -> 프로퍼티가 원시 타입의 값이 아니어야 한다.
    *  -> 추상 클래스의 추상 프로퍼티나 인스턴스의 프로퍼티에는 적용할 수 없다.
    *  -> 커스텀 게터 및 세터를 지원하는 프로퍼티에는 적용할 수 없다.
    */
    private lateinit var items: String
    override fun setUp() {
        items = "socks, jacket, laptop"
    }
    fun checkSocks() = "socks" in items
}

fun main() {
    val suitcase = BetterSuitcase()
    suitcase.setUp()
    suitcase.checkSocks() eq true
}