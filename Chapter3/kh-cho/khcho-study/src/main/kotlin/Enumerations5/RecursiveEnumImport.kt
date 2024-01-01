package Chapter3.`kh-cho`.`khcho-study`.src.main.kotlin.Enumerations5

import atomictest.eq

enum class Size {
    Tiny, Small, Medium, Large, Huge, Gigantic
}
fun main() {
        Size.Gigantic eq "Gigantic"
        Size.values().toList() eq
                listOf(
                    Size.Tiny, Size.Small, Level.Medium,
                    Size.Large, Size.Huge, Size.Gigantic
                )
        Size.Tiny.ordinal eq 0
        Size.Huge.ordinal eq 4
}