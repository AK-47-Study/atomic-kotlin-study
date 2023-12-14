package testing2
import atomictest.eq

fun main() {
    calculateBMI(160, 68) eq "Normal weight"
    calculateBMI(100, 68) eq "Underweight"
    calculateBMI(200, 68) eq "Overweight"
}

fun calculateBMI(
    weight: Int,
    height: Int
): String {
    val bmi = weight / (height * height) * 703.07

    return if (bmi < 18.5) "Underweight"
    else if (bmi < 25) "Normal weight"
    else "Overweight"
}


