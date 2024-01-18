package operatoroverloading

import Test.eq


class E(var v: Int) {
    override fun equals(other: Any?) = when {
        this === other -> true
        other !is E -> false
        else -> v === other.v
    }
    override fun hashCode(): Int = v
    override fun toString() = "E($v)"
}

fun main() {
    val a = E(1)
    val b = E(2)

    (a == b) eq false
    (a != b) eq true

    (E(1) === E(1)) eq false
}