package Chapter2.`kh-cho`.`khcho-study`.src.main.kotlin.`Packages2-6`

import kotlin.math.sqrt
class RightTriangle(
    val a: Double,
    val b: Double
) {
    fun hypotenuse() = sqrt(a * a + b * b)
    fun area() = a * b / 2
}