package Chapter6.`kh-cho`.`khcho-study`.src.main.kotlin.resourceCleanup

import Chapter6.`kh-cho`.`khcho-study`.src.main.kotlin.trace

class Usable(): AutoCloseable {
    fun func() = trace("func()")
    override fun close() = trace("close()")
}

fun main() {
    Usable().use { it.func() }
    trace eq "func() close()"
}