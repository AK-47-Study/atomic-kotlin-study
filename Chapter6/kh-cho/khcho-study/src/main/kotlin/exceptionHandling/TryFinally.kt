package Chapter6.`kh-cho`.`khcho-study`.src.main.kotlin.exceptionHandling

import Chapter6.`kh-cho`.`khcho-study`.src.main.kotlin.eq
import Chapter6.`kh-cho`.`khcho-study`.src.main.kotlin.trace

fun checkValue(value: Int){
    try {
        trace(value)
        if (value <= 0  )
            throw IllegalArgumentException(
                "value must be positive: $value "
            )
    }finally {
        trace("In finally clause for $value")
    }
}

fun main() {
    listOf(10, -10).forEach{
        try {
            checkValue(it)
        }catch (e: IncorrectInputException){
            "Produces error" eq "if it gets here"
        }catch (e: IllegalArgumentException){
            e.message eq
                    "radix 1 was not in valid range 2..36"
        }
    }
}