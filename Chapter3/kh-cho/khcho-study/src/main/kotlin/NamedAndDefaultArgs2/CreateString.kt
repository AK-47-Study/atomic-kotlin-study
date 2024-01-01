package Chapter3.`kh-cho`.`khcho-study`.src.main.kotlin.NamedAndDefaultArgs2

import atomictest.eq

fun main() {
    val list = listOf(1, 2, 3,)
    list.toString() eq "[1, 2, 3]"
    list.joinToString() eq "1z 2, 3"
    list.joinToString(prefix = "(",
            postfix = ")") eq "(1, 2, 3)"
    list.joinToString(separator = ":") eq
            "1：2：3"
}