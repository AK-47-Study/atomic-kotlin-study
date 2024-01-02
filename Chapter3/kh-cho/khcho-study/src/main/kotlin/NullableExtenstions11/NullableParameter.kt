package Chapter3.`kh-cho`.`khcho-study`.src.main.kotlin.NullableExtenstions11

import atomictest.eq

fun isNullOrEmpty(s: String?): Boolean =
    s == null || s.isEmpty()

fun main() {
    isNullOrEmpty(null) eq true
    isNullOrEmpty("") eq true

}