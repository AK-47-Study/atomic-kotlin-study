package Chapter3.`kh-cho`.`khcho-study`.src.main.kotlin.SafeCallsAndElvis9

import atomictest.eq

fun main() {
    val s1: String? = "abc"
    (s1 ?: "---") eq "abc"
    val s2: String? = null
    (s2 ?: "---") eq "---"
}