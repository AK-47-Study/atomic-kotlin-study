package Chapter3.`kh-cho`.`khcho-study`.src.main.kotlin.SafeCallsAndElvis9

import atomictest.eq

fun checkLength(s: String?, expected: Int?) {
    val length1 =
        if (s != null) s.length else null // [1]
    val length2 = s?.length // [
    length1 eq expected
    length2 eq expected
}
    fun main() {
        checkLength("abc", 3)
        checkLength(null, null)
    }