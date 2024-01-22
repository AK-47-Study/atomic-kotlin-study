package Chapter7.`kh-cho`.`khcho-study`.src.main.kotlin.creatingGenerics

import atomictest.eq

fun <T, R> Crate<T>.map(f:(T) -> R) : List<R> =
    listOf(f(get()))

fun main() {
    Crate(Car()).map { it.toString() + "x" } eq
            "[Carx]"
}