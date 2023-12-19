package WhenExpressions

import atomictest.eq

fun mixColors(first: String, second: String) =
    when (setOf(first, second)) {
        setOf("red", "blue") -> "purple"
        setOf("red", "yellow") -> "orange"
        setOf("blue", "yellow") -> "green"
        else -> "unknown"
    }

fun mixColorsListVersion(first: String, second: String) =
    when (listOf(first, second)) {
        listOf("red", "blue") -> "purple"
        listOf("red", "yellow") -> "orange"
        listOf("blue", "yellow") -> "green"
        else -> "unknown"
    }


fun main() {
    mixColors("red", "blue") eq "purple"
    mixColors("blue", "red") eq "purple"
    mixColors("blue", "purple") eq "unknown"

    mixColorsListVersion("red", "blue") eq "purple" //순서 주의
    mixColorsListVersion("blue", "red") eq "unknown"
    mixColorsListVersion("blue", "purple") eq "unknown"
}