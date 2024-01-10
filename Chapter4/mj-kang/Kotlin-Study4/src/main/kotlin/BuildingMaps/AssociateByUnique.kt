//package buildingmaps

import atomictest.eq
import buildingmaps.*

fun main() {
    val ages = people().associateBy { it.age }

    ages eq mapOf(
        21 to Person("Franz", 21),
        15 to Person("Arthricia", 15),
        25 to Person("Bill", 25),
        42 to Person("Crocubot", 42),
        33 to Person("Revolio", 33))
}