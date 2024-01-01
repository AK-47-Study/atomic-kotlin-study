package enumerations

import atomictest.eq
import enumerations.Size.*

enum class Size {
    Tiny, Small, Medium, Large, Huge, Gigantic
}

fun main() {
    Gigantic eq "Gigantic"
    Size.values().toList() eq
            listOf(
                Tiny, Small, Medium,
                Large, Huge, Gigantic
            )
    Tiny.ordinal eq 0
    Huge.ordinal eq 4
}