package OperatorOverloading

import Test.eq

fun main() {
    val x: Int? = 1
    val y: Int = 2

    val sum = x ?: 0 + y
    sum eq 1

    (x ?: 0) + y eq 3
    x ?: (0 + y) eq 1
}