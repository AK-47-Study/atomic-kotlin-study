package Chapter2.`kh-cho`.`khcho-study`.src.main.kotlin.`ObjectsEverywhere2-1`

fun main() {
    val num = 1
    val den = 2
    val f = fraction(num.toLong(), den.toLong())
    println(f)
}

fun fraction(numerator: Long, denom: Long) =
    numerator.toDouble() / denom
