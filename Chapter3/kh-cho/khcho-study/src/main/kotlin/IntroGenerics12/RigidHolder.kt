package Chapter3.`kh-cho`.`khcho-study`.src.main.kotlin.IntroGenerics12

import atomictest.eq

data class Automobile(val brandL: String)
class RigidHolder(private val a: Automobile) {
    fun getValue() = a
}

fun main() {
    val holder = RigidHolder(Automobile("BMW"))
    holder.getValue() eq
            "Automobile(brand=BMW)"

}