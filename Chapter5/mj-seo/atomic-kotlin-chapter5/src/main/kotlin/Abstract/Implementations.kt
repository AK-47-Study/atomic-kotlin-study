package abstractclasses

import Test.eq


interface Parent {
    val ch: Char
    fun f(): Int

    // 구현이 있는 함수를 포함할 수 있다.
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