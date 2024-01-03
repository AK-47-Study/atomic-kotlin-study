package Chapter3.`kh-cho`.`khcho-study`.src.main.kotlin.IntroGenerics12

import atomictest.eq

fun <T> identity(arg: T): T = arg
fun main() {
    identity("Yellow") eq "Yellow"
    identity(1) eq 1

    val d: Dog = identity(Dog())
    d.bark() eq "Ruff!"
}