package Chapter2.`kh-cho`.`khcho-study`.src.main.kotlin.PropertyAccessors

import atomictest.eq

class Hamsters(val name :String)

class Cage(private val maxCapacity: Int) {
    private val hamsters =
        mutableListOf<Hamsters>()
    val capacity: Int
        get() = maxCapacity - hamsters.size
    val full: Boolean
        get() = hamsters.size == maxCapacity

    fun put(hamster: Hamsters): Boolean =
        if (full)
            false
        else {
            hamsters += hamster
            true
        }

    fun take(): Hamsters =
        hamsters.removeAt(0)
    }
fun main() {
    val cage = Cage(2)
    cage.full eq false
    cage.capacity eq 2
    cage.put(Hamsters("Alice ")) eq true
    cage.put(Hamsters("Bob")) eq true
    cage.full eq true
    cage.capacity eq 0
    cage.put(Hamsters("Charlie")) eq false
    cage.take()
    cage.capacity eq 1
}