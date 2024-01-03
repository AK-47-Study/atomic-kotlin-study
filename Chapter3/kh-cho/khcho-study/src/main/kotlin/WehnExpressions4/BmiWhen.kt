package Chapter3.`kh-cho`.`khcho-study`.src.main.kotlin.WehnExpressions4

import atomictest.eq

fun bmiMetric01d(
    kg: Double,
    heightM: Double
):String {
    val bmi = kg / (heightM * heightM)
    return if (bmi < 18.5) "Underweight"
    else if (bmi < 25) "Normal weight"
    else "Overweight"
}
    fun bmiMetricWithWhen(
        kg: Double,
        heightM: Double
    ):String {
        val bmi = kg / (heightM * heightM)
        return when {
            bmi < 18.5 -> "Underweight"
            bmi < 25 -> "Normal weight"
            else -> "Overweight"
        }
    }
fun main() {
                bmiMetric01d(72.57, 1.727) eq
                        bmiMetricWithWhen(72.57, 1.727)
}