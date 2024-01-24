package lateinitialization

import Test.capture


class FaultySuitcase : Bag {
    lateinit var items: String
    override fun setUp() {}
    fun checkSocks() = "socks" in items
}

fun main() {
    val suitcase = FaultySuitcase()
    suitcase.setUp()

    capture {
        suitcase.checkSocks()
        // lateinit 프로퍼티를 초기화하지 않으면, 컴파일 시점에 알 수 없고 런타임에 예외를 발생시킨다.
    } eq "UninitializedPropertyAccessException: lateinit property items has not been initialized"
}