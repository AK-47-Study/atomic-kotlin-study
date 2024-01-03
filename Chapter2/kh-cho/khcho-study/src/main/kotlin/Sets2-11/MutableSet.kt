package Chapter2.`kh-cho`.`khcho-study`.src.main.kotlin.`Sets2-11`

import atomictest.eq

fun main() {
    val mutableSet = mutableSetOf<Int>()
    mutableSet += 42
    mutableSet += 42
    mutableSet eq setOf(42)
    mutableSet -= 42
    mutableSet eq setOf<Int>()
}