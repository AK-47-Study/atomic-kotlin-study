package NumberTypes

fun bmiMetric(
    weight: Int,
    height: Int
): String {
    val bmi = weight / (height * height)
    return if (bmi < 18.5) "Underweight"
    else if (bmi < 25) "Normal weight"
    else "Overweight"
}

fun main() {
    val weight = 160
    val height = 68
    val status = bmiMetric(weight, height)

    println(status)
}