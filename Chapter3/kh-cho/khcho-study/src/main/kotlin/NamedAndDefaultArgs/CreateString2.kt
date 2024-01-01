package Chapter3.`kh-cho`.`khcho-study`.src.main.kotlin.NamedAndDefaultArgs

import atomictest.eq

fun main() {
    val list = listOf(1, 2, 3)
    list.joinToString(", ", "H", "！") eq
            "1. 2. 3!"
    list.joinToString(
        separator = ", ",
        postfix = "!") eq "1.2.3!"
}