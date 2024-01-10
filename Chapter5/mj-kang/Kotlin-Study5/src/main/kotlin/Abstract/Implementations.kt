package abstractclasses

import atomictest.eq


interface Parent {
    val ch: Char
    fun f(): Int

    fun g() = "ch = $ch; f() = ${f()}"
}

class Actual(
    override val ch: Char
): Parent {
    override fun f() = 17
}

class Other : Parent {
    override val ch: Char
        get() = 'B'
    override fun f() = 34
}

fun main() {
    Actual('A').g() eq "ch = A; f() = 17"
    Other().g() eq "ch = B; f() = 34"
}

