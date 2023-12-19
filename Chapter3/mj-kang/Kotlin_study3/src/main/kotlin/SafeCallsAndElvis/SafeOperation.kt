package safecalls

import atomictest.trace

fun String.echo() {
    trace(uppercase())
    trace(this)
    trace(lowercase())
}

fun main() {
    val s1: String? = "Howdy!"
    s1?.echo()

    val s2: String? = null
    s2?.echo()

    trace eq """
        HOWDY!
        Howdy!
        howdy!
    """.trimIndent()
}