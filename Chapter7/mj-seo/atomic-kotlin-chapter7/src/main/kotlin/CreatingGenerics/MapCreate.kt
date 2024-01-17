package creatinggenerics

import Test.eq


fun <T, R> Create<T>.map(f: (T) -> R): List<R> =
    listOf(f(get()))

fun main() {
    Create(Car()).map { it.toString() + "x" } eq
            "[Carx]"
}