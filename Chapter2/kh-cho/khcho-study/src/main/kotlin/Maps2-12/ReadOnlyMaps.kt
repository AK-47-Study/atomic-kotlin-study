package Chapter2.`kh-cho`.`khcho-study`.src.main.kotlin.`Maps2-12`

import atomictest.eq

fun main() {
    val m = mapOf(5 to "five", 6 to "six")
    m[5] eq "five"
    // m [5] = "5ive"
    // m += (4 to "four")
    m + (4 to "four")
    m eq mapOf(5 to "five", 6 to "six")
    val m2 = m +(4 to "four")
    m2 eq mapOf(
        5 to "five", 6 to "six", 4 to "four"
    )
}