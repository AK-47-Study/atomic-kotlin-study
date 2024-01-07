package Chapter3.`kh-cho`.`khcho-study`.src.main.kotlin.NonNullAssertions10

import atomictest.capture
import atomictest.eq

fun main() {
    var x: String? = "abc"
    x!! eq "abc"
    x = null
    capture {
        val s: String = x!!
    } eq "NullPointerException"
}