package Chapter6.`kh-cho`.`khcho-study`.src.main.kotlin.exceptionHandling

import Chapter6.`kh-cho`.`khcho-study`.src.main.kotlin.eq

class IncorrectInputException(
    message: String
): Exception(message)

fun checkCode(code: Int){
    if (code <= 1000){
        throw IncorrectInputException(
            "Code must be > 1000: $code"
        )
    }
}

fun main() {
    try {
        checkCode("A1".toInt(16))
    }catch (e: IncorrectInputException  ) {
        e.message eq "Code must be > 1000: 161"
    }catch (e : IllegalArgumentException){
        "Produces error" eq "if it get here"
    }

    try {
        checkCode("1".toInt(1))
    }catch (e: IncorrectInputException) {
        "Produces error" eq "if it gets here"
    }catch (e : IllegalArgumentException){
        e.message eq
                "radix 1 was not in valid range 2..36"
    }
}