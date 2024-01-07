package Chapter5.`kh-cho`.`khcho-study`.src.main.kotlin.CompanionObjects

import atomictest.eq

class Counted {
    companion object {
        private var count = 0
    }

    private val id = count++
    override fun toString() = "#$id"
}
fun main() {
    List(4) { Counted } eq "[#0, #1, #2, #3]"
}