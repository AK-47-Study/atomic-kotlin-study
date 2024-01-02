package Chapter3.`kh-cho`.`khcho-study`.src.main.kotlin.NullableExtenstions

import atomictest.eq

fun isNullOrEmpty(s: String?): Boolean =
    s == null || s.isEmpty()

fun main() {
    isNullOrEmpty(null) eq true
    isNullOrEmpty("") eq true

}