package Chapter4.`kh-cho`.`khcho-study`.src.main.kotlin.Lambdas1

import atomictest.eq

fun main() {
    val list = listOf('a', 'b', 'c')
    list.indices.map {
        "[$it]"
    } eq listOf("[0]", "[1]", "[2]")
}