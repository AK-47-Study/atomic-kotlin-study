package lazyinitialization

import Test.trace

// lazy(지연 계산) 프로퍼티는 처음 사용할 때 초기화 된다 -> 생성 시점 X
val idle: String by lazy {
    trace("Initializing 'idle'")
    "I'm never used"
}

val helpful: String by lazy {
    trace("Initializing 'helpful'")
    "I'm helping"
}

fun main() {
    trace(helpful)
    trace eq """
        Initializing 'helpful'
        I'm helping
    """.trimIndent()
}