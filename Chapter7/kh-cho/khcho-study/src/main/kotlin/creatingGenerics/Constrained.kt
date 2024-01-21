package Chapter7.`kh-cho`.`khcho-study`.src.main.kotlin.creatingGenerics

import atomictest.eq

fun <T: Disposable> nameOf(disposable: T) =
    disposable.name

fun <T: Disposable> T.name() = name

fun main() {
    recyclable.map { nameOf(it) } eq
            "[Plastic, Metal, Cardboard]"
    recyclable.map { it.name() } eq
            "[Plastic, Metal, Cardboard]"
}