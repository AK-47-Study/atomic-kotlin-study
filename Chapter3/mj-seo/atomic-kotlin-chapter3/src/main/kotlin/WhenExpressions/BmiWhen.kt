package whenexpressions

import atomictest.eq


fun bmiMetricOld(
    kg: Double,
    heightM: Double,
): String {
    val bmi = kg / (heightM * heightM)
    return if (bmi < 18.5) "Underweight"
           else if (bmi < 25) "Normal weight"
           else "Overweight"
}

fun bmiMetricWithWhen(
    kg: Double,
    heightM: Double,
): String {
   val bmi = kg / (heightM * heightM)
   return when {
       bmi < 18.5 -> "Underweight"
       bmi < 25 -> "Normal weight"
       else -> "Overweight"
   }
}

fun main() {
    bmiMetricOld(77.57, 1.727) eq
            bmiMetricWithWhen(77.57, 1.727)
}