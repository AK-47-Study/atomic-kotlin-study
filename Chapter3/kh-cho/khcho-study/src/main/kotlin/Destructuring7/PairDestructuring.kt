package Chapter3.`kh-cho`.`khcho-study`.src.main.kotlin.Destructuring7

import atomictest.eq

fun main() {
    val (value, description) = compute(7)
    value eq 14
    description eq "High"
}