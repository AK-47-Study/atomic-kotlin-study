package Chapter3.`kh-cho`.`khcho-study`.src.main.kotlin.IntroGenerics12

import atomictest.eq

class GenericHolder<T>( // [1]
    private val value: T
){
    fun getValue(): T = value
}
fun main() {
    val hi = GenericHolder(Automobile("Ford"))

    val a: Automobile = hi.getValue()
    a eq "Automobile(brand=Ford)"

    val h2 = GenericHolder(1)

    val i: Int = h2.getValue()
    i eq 1

    val h3 = GenericHolder("Chartreuse")

    val s: String = h3.getValue()
    s eq "Chartreuse"

}