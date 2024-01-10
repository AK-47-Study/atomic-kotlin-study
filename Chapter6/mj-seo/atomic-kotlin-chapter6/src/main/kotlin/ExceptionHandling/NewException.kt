package exceptionhandling

import Test.eq
import java.lang.IllegalArgumentException


class IncorrectInputException(
    message: String
) : Exception(message)

fun checkCode(code: Int) {
    if (code <= 1000) {
        throw IncorrectInputException(
            "Code must be > 1000: $code"
        )
    }
}

fun main() {
    try {
        checkCode("A1".toInt(16))
        // 다른 예외타입을 구분해서, 예외 케이스 별로 다른 동작을 하게 처리할 수 있다.
    } catch (e: IncorrectInputException) {
        e.message eq "Code must be > 1000: 161"
    } catch (e: IllegalArgumentException) {
        "Produces error" eq "if it gets here"
    }

    try {
        checkCode("1".toInt(1))
    } catch (e: IncorrectInputException) {
        "Produces error" eq "if it gets here"
    } catch (e: IllegalArgumentException) {
        e.message eq
                "radix 1 was not in valid range 2..36"
    }
}