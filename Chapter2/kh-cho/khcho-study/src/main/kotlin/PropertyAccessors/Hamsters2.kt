package Chapter2.`kh-cho`.`khcho-study`.src.main.kotlin.PropertyAccessors

class Cage2(private val maxCapacity: Int) {
    private val hamsters =
        mutableListOf<Hamsters>()
    fun capacity() : Int =
        maxCapacity - hamsters.size
    fun isFull(): Boolean =
        hamsters.size == maxCapacity
}