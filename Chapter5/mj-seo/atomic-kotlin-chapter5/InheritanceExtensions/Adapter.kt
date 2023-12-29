package inheritanceextensions

import Test.trace
import usefulllibrary.LibType
import usefulllibrary.utility1
import usefulllibrary.utility2

open class MyClass {
    fun g() = trace("g()")
    fun h() = trace("h()")
}

fun useMyClass(mc: MyClass) {
    mc.g()
    mc.h()
}

class MyClassAdapterForLib :
        MyClass(), LibType {
    override fun f1() = h()

    override fun f2() = g()
        }

fun main() {
    val mc = MyClassAdapterForLib()
    utility1(mc)
    utility2(mc)
    useMyClass(mc)

    trace eq "h() g() g() h() g() h()"
}