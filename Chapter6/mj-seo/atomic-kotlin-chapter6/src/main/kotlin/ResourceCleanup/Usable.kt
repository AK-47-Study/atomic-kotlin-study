package resourcecleanup

import Test.trace


class Usable() : AutoCloseable {
    fun func() = trace("func()")
    override fun close() = trace("close()")
}

fun main() {
    // use()를 사용하면 자원을 생성하는 시점에 자원 해제를 확실히 보장한다.
    Usable().use { it.func() }
    trace eq "func() close()"
}