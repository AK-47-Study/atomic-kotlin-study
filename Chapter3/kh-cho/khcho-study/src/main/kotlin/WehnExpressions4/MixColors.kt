package Chapter3.`kh-cho`.`khcho-study`.src.main.kotlin.WehnExpressions4

import atomictest.eq

fun mixColors(first: String, second: String) =
when (setOf(first, second)) {
    setOf("red", "blue") -> "purple"
    setOf("red", "yellow") -> "orange"
    setOf("blue", "yellow") -> "green"

    else -> "unknown"
}
fun main() {
        mixColors("red", "blue") eq "purple"
        mixColors("blue", "red") eq "purple"
        mixColors("blue", "purple") eq "unknown"
}