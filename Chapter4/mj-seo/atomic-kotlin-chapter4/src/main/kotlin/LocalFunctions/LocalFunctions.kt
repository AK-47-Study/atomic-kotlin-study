import Test.eq


fun main() {
    val logMsg = StringBuilder()

    // 다른 함수 안에 정의된 이름 붙은 함수를 지역 함수라고 한다.
    fun log(message: String) =
        logMsg.appendLine(message)

    log("Starting computation")

    val x = 42
    log("Computation result: $x")

    logMsg.toString() eq """
        Starting computation
        Computation result: 42
    """.trimIndent()
}