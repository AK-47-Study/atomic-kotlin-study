package exceptionhandling
import Test.trace


fun checkValue(value: Int) {
    try {
        trace(value)
        if (value <= 0)
            throw IllegalArgumentException(
                "value must be positive: $value"
            )
    } finally {
        // finally 절은 예외 발생 여부와 상관없이 항상 실행된다.
        trace("In finally clause for $value")
    }
}

fun main() {
    listOf(10, -10).forEach {
        try {
            checkValue(it)
        } catch (e: IllegalArgumentException) {
            trace("In catch clause for main()")
            trace(e.message)
        }
    }

    trace eq """
        10
        In finally clause for 10
        -10
        In finally clause for -10
        In catch clause for main()
        value must be positive: -10
    """.trimIndent()
}