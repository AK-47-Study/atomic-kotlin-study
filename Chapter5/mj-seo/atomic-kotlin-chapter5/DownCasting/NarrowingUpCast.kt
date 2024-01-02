package downcasting


interface Base {
    fun f()
}

class Derived1 : Base {
    override fun f() {}
    fun g() {}
}

class Derived2 : Base {
    override fun f() {}
    fun h() {}
}

fun main() {
    val b1: Base = Derived1()
    b1.f()

//    b1.g() -> 기반 클래스에 포함된 함수가 아니다.

    val b2: Base = Derived2()
    b2.f()
//    b2.h() -> 기반 클래스에 포함된 함수가 아니다.
}