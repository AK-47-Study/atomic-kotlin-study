package Chapter6.`kh-cho`.`khcho-study`.src.main.kotlin.exceptionHandling

import Chapter6.`kh-cho`.`khcho-study`.src.main.kotlin.eq

data class Switch(
    var on: Boolean = false,
    var result: String = "OK"
)

fun testFinally(i: Int): Switch{
    val sw = Switch()
    try {
        sw.on = true
        when(i) {
            0 -> throw IllegalArgumentException()
            1 -> return sw
        }
    }catch (e : IllegalArgumentException){
        sw.result = "exception"
    }finally {
        sw.on = false
    }
    return sw
}

fun main() {
    testFinally(0) eq
            "Switch(on=false, result=exception)"
    testFinally(1 ) eq
            "Switch(on=false, result=OK)"
    testFinally(2) eq
            "Switch(on=false, result=OK)"
}