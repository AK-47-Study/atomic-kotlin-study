package Chapter2.`kh-cho`.`khcho-study`.src.main.kotlin.`Lists2-9`

import atomictest.capture

fun main() {
    val ints = listOf(1, 2, 3)
    capture {
        ints[3]
    } contains
            listOf("ArraylndexOutOfBoundsException")
}