package Chapter4.`kh-cho`.`khcho-study`.src.main.kotlin.Lambdas1

import atomictest.eq

fun main() {
    val list = listOf('a', 'b', 'c', 'd')
    val result =
        list.map({ "[${it.toUpperCase()}]"})
    result eq listOf("[A]", "[B]", "[C]", "[D]")
}