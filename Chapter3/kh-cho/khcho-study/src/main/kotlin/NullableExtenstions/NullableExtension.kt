package Chapter3.`kh-cho`.`khcho-study`.src.main.kotlin.NullableExtenstions

import atomictest.eq

fun String?.isNullOrEmpty(): Boolean =
    this == null || isEmpty()
fun main() {
    "".isNullOrEmpty() eq true

}