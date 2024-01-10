package higherorderfunctions

import atomictest.eq


val isPlus: (Int) -> Boolean = { it > 0 }
val isContains: (String) -> Boolean = { it.contains("A") }

fun main() {
    listOf(1, 2, -3).any(isPlus) eq true
    listOf("ABC", "CB", "CCC").any(isContains) eq true
}

