package Chapter4.`kh-cho`.`khcho-study`.src.main.kotlin.Lambdas1

import atomictest.eq

fun main() {
    val list = listOf(1,2,3,4)
    val result = list.map ({ n -> "[$n]"} )
    result eq listOf("[1]", "[2]", "[3]", "[4]")
}