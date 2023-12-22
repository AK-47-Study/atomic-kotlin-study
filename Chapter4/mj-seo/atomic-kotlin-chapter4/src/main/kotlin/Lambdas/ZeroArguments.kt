import Test.trace


fun main() {
    // 코틀린 스타일 가이드에서는 파라미터가 없는 사실을 강조하는 화살표를 사용하지 말라고 권장한다.
    run { -> trace("A Lambda") }
    run { trace("Without args") }

    trace eq """
        A Lambda
        Without args
    """.trimIndent()
}