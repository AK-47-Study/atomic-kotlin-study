package Chapter7.`kh-cho`.`khcho-study`.src.main.kotlin.extensionLambdas

import atomictest.eq

open class Base {
    open fun f() = 1
}

class Derived: Base(){
    override fun f() = 99
}

fun Base.g() = f()

fun Base.h(xl: Base.() -> Int) = xl()

fun main() {
    val b: Base = Derived()
    b.g() eq  99
    b.h { f()   } eq 99
}