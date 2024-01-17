package creatinggenerics

import Test.eq


fun <T: Disposable> nameOf(disposable: T) =
    disposable.name

fun <T: Disposable> T.name() = name

fun main() {
    recyclables.map { nameOf(it) } eq
            "[Plastic, Metal, Cardboard]"

    recyclables.map { it.name } eq
            "[Plastic, Metal, Cardboard]"
}