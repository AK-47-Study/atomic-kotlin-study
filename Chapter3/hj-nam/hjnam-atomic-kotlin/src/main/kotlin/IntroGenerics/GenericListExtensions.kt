package introgenerics
import atomictest.eq

fun <T> List<T>.first(): T {
    if (isEmpty())
        throw NoSuchElementException("Empty List")
    return this[0]
}

fun <T> List<T>.firstOrNull(): T? =
    if (isEmpty()) null else this[0]

fun main() {
    listOf(1, 2, 3).first() eq 1
    val i: Int? = // ?를 없애면 "Kotlin: Type mismatch: inferred type is Int? but Int was expected"
        listOf(1, 2, 3).firstOrNull()
    i eq 1
    val s: String? =
        listOf<String>().firstOrNull()
    s eq null
}