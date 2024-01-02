package Chapter3.`kh-cho`.`khcho-study`.src.main.kotlin.NullableTypes8

import atomictest.eq

fun main() {
    val s: String? = "abc"
    if (s != null)
        s.length eq 3
}