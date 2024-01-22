package Chapter5.`kh-cho`.`khcho-study`.src.main.kotlin.Objects

import atomictest.eq

object JustOne{
    val n = 2
    fun f() = n * 10
    fun g () = n * 20
}

fun main() {
    JustOne.n eq 2
    JustOne.f() eq 20
    JustOne.g() eq 40
}