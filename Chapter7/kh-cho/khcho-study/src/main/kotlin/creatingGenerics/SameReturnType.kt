package Chapter7.`kh-cho`.`khcho-study`.src.main.kotlin.creatingGenerics

import kotlin.random.Random

private val rnd = Random(47)

fun List<Disposable>.aRandom() : Disposable =
    this[rnd.nextInt(size)]

fun <T: Disposable> List<T>.bRandom(): T =
    this[rnd.nextInt(size)]

fun <T> List<T>.cRandom(): T =
    this[rnd.nextInt(size)]

fun sameReturnType() {
    val a: Disposable = recyclable.aRandom()
    val b: Recyclable = recyclable.bRandom()
    val c: Recyclable = recyclable.cRandom()
}