package introgenerics

import atomictest.eq

fun <T> List<T>.first(): T {
    if (isEmpty())
        throw NoSuchElementException("Empty List")
    return this[0]
}

fun <T> Set<T>.printAll() {
    for (element in this) {
        println(element)
    }
}

fun <T> List<T>.firstOrNull(): T? =
    if (isEmpty()) null else this[0]

fun main() {
    listOf(1, 2, 3).first() eq 1

    val i: Int? =
        listOf(1, 2, 3).firstOrNull()
    i eq 1

    val s: String? =
        listOf<String>().firstOrNull()
    s eq null

    val set = setOf(1, 2, 3)
    set.printAll()
}