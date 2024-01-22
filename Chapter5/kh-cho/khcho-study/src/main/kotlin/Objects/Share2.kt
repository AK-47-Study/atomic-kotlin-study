package Chapter5.`kh-cho`.`khcho-study`.src.main.kotlin.Objects

import atomictest.eq

fun g() {
    Shared.i += 7
}
    fun main() {
        f()
        g()
        Shared.i eq 12
}