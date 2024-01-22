package Chapter7.`kh-cho`.`khcho-study`.src.main.kotlin.creatingGenerics

import kotlin.random.Random

private val rnd = Random(47)

fun List<Disposable>.inexact(): Disposable{
    val d: Disposable = this[rnd.nextInt(size)]
    d.action()
    return d
}

fun <T> List<T>.noAccess(): T{
    val d: T = this[rnd.nextInt(size)]
    // d.action()
    return d
}

fun <T:Disposable> List<T>.both(): T{
    val d: T = this[rnd.nextInt(size)]
    d.action()
    return d
}

fun main() {
    val i: Disposable = recyclable.inexact()
    val n: Recyclable = recyclable.noAccess()
    val b: Recyclable = recyclable.both()
}