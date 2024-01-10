package companionobjects

import Test.trace


interface ZI {
    fun f(): String
    fun g(): String
}

open class ZIOpen : ZI {
    override fun f() = "ZIOpen.f()"

    override fun g() = "ZIOpen.g()"
}

class ZICompanion {
    companion object: ZIOpen()
    fun u() = trace("${f()} ${g()}")
}

class ZICompanionInheritance {
    companion object: ZIOpen() {
        override fun g() =
            "ZICompanionInheritance.g()"
        fun h() = "ZICompanionInheritance.h()"
    }
    fun u() = trace("${f()} ${g()} ${h()}")
}

class ZIClass {
    // 동반 객체를 만들면서 인터페이스를 구현할 수 있다.
    companion object: ZI {
        override fun f() = "ZIClass.f()"
        override fun g() = "ZIClass.g()"
    }
    fun u() = trace("${f()} ${g()}")
}

fun main() {
    ZIClass.f()
    ZIClass.g()
    ZIClass().u()
    ZICompanion.f()
    ZICompanion.g()
    ZICompanion().u()
    ZICompanionInheritance.f()
    ZICompanionInheritance.g()
    ZICompanionInheritance().u()

    trace eq """
        ZIClass.f() ZIClass.g()
        ZIOpen.f() ZIOpen.g()
        ZIOpen.f()
        ZICompanionInheritance.g()
        ZICompanionInheritance.h()
    """.trimIndent()
}