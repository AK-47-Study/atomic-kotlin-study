package Chapter6.`kh-cho`.`khcho-study`.src.main.kotlin.nothingType

import Chapter6.`kh-cho`.`khcho-study`.src.main.kotlin.capture

fun later(s: String) : Int = TODO("later()")

fun later2(s: String) : Int = TODO()


fun main() {
    capture {
        later("Hello")
    } eq "NotImplementedError: " +
            "An operation is not implemented: later()"
    capture {
        later2("Hello!")
    } eq "NotImplementedError: " +
            "An operation is not implemented."
}