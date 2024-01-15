package extensionlambdas

import Test.eq


open class Base {
    open fun f() = 1
}

class Derived : Base() {
    override fun f() = 99
}

fun Base.g() = f()

fun Base.h(xl: Base.() -> Int) = xl()

fun main() {
    // 일반 확장 함수와 확장 람다에서 다형성이 동작하는 것을 알 수 있다.
    val b: Base = Derived()
    b.g() eq 99
    b.h { f() } eq 99
}