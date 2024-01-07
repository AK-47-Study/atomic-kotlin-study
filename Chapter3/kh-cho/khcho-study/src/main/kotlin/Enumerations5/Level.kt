package Chapter3.`kh-cho`.`khcho-study`.src.main.kotlin.Enumerations5

import atomictest.eq

enum class Level{
    Overflow, High, Medium, Low, Empty
}

fun main() {
    Level.Medium eq "Medium"
}