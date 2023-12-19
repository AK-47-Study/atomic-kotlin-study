package NullableTypes

import atomictest.eq


fun main() {
    val s1: String = "abc"
    val s2: String? = s1

    s1.length eq 3

}