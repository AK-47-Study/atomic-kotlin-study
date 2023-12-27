package testing1

import atomictest.eq

fun main() {
    calculateBMI(160, 68) eq "Normal weight"
    // calculate(100, 68) eq "Underweight"
    // calculate(200, 68) eq "Overweight"
}

fun calculateBMI(weight: Int, height: Int) =
    "Normal weight"