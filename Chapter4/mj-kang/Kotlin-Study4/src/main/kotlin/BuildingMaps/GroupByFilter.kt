//package buildingmaps

import atomictest.eq
import buildingmaps.*


fun main() {
    val groups = people().groupBy { it.name.first() }

    groups['A'] eq listOf(
        Person("Alice", 21),
        Person("Arthricia", 15))

    groups['Z'] eq null

    people().filter {
        it.name.first() == 'A'
    } eq listOf(
        Person("Alice", 21),
        Person("Arthricia", 15))

    people().filter {
        it.name.first() == 'F'
    } eq listOf(Person("Franz", 21))

    people().partition {
        it.name.first() == 'A'
    } eq Pair(
        listOf(
            Person("Alice", 21),
            Person("Arthricia", 15)),
        listOf(Person("Bob", 25),
            Person("Bill", 25),
            Person("Birdperson", 42),
            Person("Charlie", 21),
            Person("Crocubot", 42),
            Person("Franz", 21),
            Person("Revolio", 33)))
}