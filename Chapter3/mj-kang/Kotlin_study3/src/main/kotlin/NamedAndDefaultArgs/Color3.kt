package color3

import atomictest.eq

class Color(
    private val red: Int = 0,
    private val green: Int = 0,
    private val blue: Int = 0,
) {
    override fun toString() =
        "($red, $green, $blue)"
}

fun main() {
    Color(red = 77).toString() eq "(77, 0, 0)"
}