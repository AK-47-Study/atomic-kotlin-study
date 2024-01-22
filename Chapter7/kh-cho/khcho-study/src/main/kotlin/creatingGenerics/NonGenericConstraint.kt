package Chapter7.`kh-cho`.`khcho-study`.src.main.kotlin.creatingGenerics

import atomictest.eq

fun nameOf2(disposable: Disposable) =
    disposable.name

fun Disposable.name2() = name

fun main() {
    recyclable.map { nameOf2(it) } eq
            "[Plastic, Metal, Cardboard]"
    recyclable.map { it.name2() } eq
            "[Plastic, Metal, Cardboard]"
}