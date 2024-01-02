package Chapter3.`kh-cho`.`khcho-study`.src.main.kotlin.NullableExtenstions11

import atomictest.eq

fun String?.isNullOrEmpty(): Boolean =
    this == null || isEmpty()
fun main() {
    "".isNullOrEmpty() eq true

}