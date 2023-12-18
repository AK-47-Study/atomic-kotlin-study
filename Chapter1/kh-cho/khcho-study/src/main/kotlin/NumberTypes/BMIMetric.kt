package Chapter1.`kh-cho`.`khcho-study`.src.main.kotlin.NumberTypes

fun main() {
    val weight = 72.57
    val height = 1.727
    val status = bmiMetric(weight, height)
    println(status)
}

fun bmiMetric(weight: Double, height: Double): String {
    val bmi = weight / (height * height)
    return if (bmi < 18.5) "Underweight"
    else if (bmi < 25) "Normal weight"
    else "Overweight"
}
