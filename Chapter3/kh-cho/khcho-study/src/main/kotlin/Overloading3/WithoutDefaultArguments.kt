package Chapter3.`kh-cho`.`khcho-study`.src.main.kotlin.Overloading3

import atomictest.eq

fun f(n: Int) = n + 373
fun f() = f(0)
fun main() {
    f() eq 373
}