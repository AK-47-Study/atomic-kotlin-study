package Chapter2.`kh-cho`.`khcho-study`.src.main.kotlin.`Sets2-11`

import atomictest.eq

fun main() {
    val list = listOf(3,3,2,1,2)
    list.toSet() eq setOf(1,2,3)
    list.distinct() eq listOf(3,2,1)
    "aabbcc".toSet() eq setOf('a', 'b', 'c')
}