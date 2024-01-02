package Chapter3.`kh-cho`.`khcho-study`.src.main.kotlin.ExtensionProperties

import atomictest.eq

val String.indices: IntRange
    get() = 0 until length

fun main() {
    "abc".indices eq 0..2
}