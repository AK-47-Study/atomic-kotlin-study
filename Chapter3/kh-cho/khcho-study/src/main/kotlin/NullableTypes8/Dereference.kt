package Chapter3.`kh-cho`.`khcho-study`.src.main.kotlin.NullableTypes8

import atomictest.eq

fun main() {
    val s1: String = "abc"
    val s4: String? = s1
    s1.length eq 3 // [1 ]

    // 컴파일되지 않는다
    // s2.length // [2]
}