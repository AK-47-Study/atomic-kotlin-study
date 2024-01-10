package inheritanceextensions2

import atomictest.trace
import usefulllibrary.LibType
import usefulllibrary.utility1
import usefulllibrary.utility2

class MyClass {
    fun g() = trace("g()")
    fun h() = trace("h()")
}

fun useMyClass(mc: MyClass) {
    mc.g()
    mc.h()
}

class MyClassAdapterForLib: LibType {
    val field = MyClass()
    override fun f1() = field.h()

    override fun f2() = field.g()
}

fun main() {
    val mc = MyClassAdapterForLib()
    utility1(mc)
    utility2(mc)
    useMyClass(mc.field)

    trace eq "h() g() g() h() g() h()"
}

