package exceptionhandling
import Test.eq


fun testCode(code: Int) {
    if (code <= 1000) {
        throw IllegalArgumentException(
            "'code' must be > 1000: $code"
        )
    }
}

fun main() {
    try {
        // A1은 16진수 표기로 161이다
        testCode("A1".toInt(16))
    } catch (e: IllegalArgumentException) {
        e.message eq
                "'code' must be > 1000: 161"
    }

    try {
        testCode("0".toInt(1))
        // radix로 인한 예외가 발생했지만, input이 잘못되었을때와 예외 종류가 같아 혼란이 생긴다.
    } catch (e: IllegalArgumentException) {
        e.message eq
                "radix 1 was not in valid range 2..36"
    }
}