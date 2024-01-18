package operatoroverloading

import Test.eq


data class C(val c: MutableList<Int>) {
    override fun toString() = "C($c)"
}

operator fun C.contains(e: E) = e.v in c

operator fun C.get(i: Int) = E(c[i])

operator fun C.set(i: Int, e: E) {
    c[i] = e.v
}

fun main() {
    val c = C(mutableListOf(2, 3))
    (E(2) in c) eq true
    (E(4) in c) eq false

    c[1] eq E(3)  // c.get(1)
    c[1] = E(4)   // c.set(2, E(4))

    c eq C(mutableListOf(2, 4))
}