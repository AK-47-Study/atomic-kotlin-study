package lazyinitialization

import Test.trace


fun compute(i: Int): Int {
    trace("Compute $i")
    return i
}

object Properties {
    val atDefinition = compute(1)
    val getter
        get() = compute(2)

    val lazyInit by lazy { compute(3) }
    val never by lazy { compute(4) }
}

fun main() {
    listOf(
        // 초기화가 프로퍼티 접근 이전에 발생한다.
        Properties::atDefinition,
        // 프로퍼티에 접근할 때마다 getter가 계산된다.
        Properties::getter,
        // lazyInit 프로퍼티에 처음 접근할 때 한 번만 계산된다.
        Properties::lazyInit
    ).forEach {
        trace(it.name)
        trace("${it.get()}")
        trace("${it.get()}")
    }

    trace eq """
        Compute 1
        atDefinition
        1
        1
        getter
        Compute 2
        2
        Compute 2
        2
        lazyInit
        Compute 3
        3
        3
    """.trimIndent()
}