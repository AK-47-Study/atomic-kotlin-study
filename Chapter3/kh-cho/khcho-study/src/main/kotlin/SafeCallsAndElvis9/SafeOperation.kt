package Chapter3.`kh-cho`.`khcho-study`.src.main.kotlin.SafeCallsAndElvis9

import atomictest.trace

fun String.echo() {
    trace(toUpperCase())
    trace(this)
    trace(toLowerCase())
}

    fun main() {
        val s1: String? = "Howdy!"
        s1?.echo() // [1]
        val s2: String? = null
        s2?.echo() // [2]
        trace eq """
            HOWDY!
            Howdy!
            howdy!
        """
    }