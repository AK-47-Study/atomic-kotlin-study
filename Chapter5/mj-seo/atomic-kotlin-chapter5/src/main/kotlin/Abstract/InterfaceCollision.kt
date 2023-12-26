package collision

import Test.eq


interface A {
    fun f() = 1
    fun g() = "A.g"
    val n: Double
        get() = 1.1
}

interface B {
    fun f() = 2
    fun g() = "B.g"
    val n: Double
        get() = 2.2
}

class C : A, B {
    override fun f() = 0
    /*
    *  함수 f()와 g()와 프로퍼티 n의 시그니처가 같으므로
    *  이 문제를 해결하지 않으면 코틀린은 오류를 표시한다.
    *  -> super<Type>으로 부등호로 클래스 이름을 지정해 호출하면, 문제를 해결할 수 있다.
    */
    override fun g() = super<A>.g()
    override val n: Double
        get() = super<A>.n + super<B>.n
}

fun main() {
    val c = C()
    c.f() eq 0
    c.g() eq "A.g"
    c.n eq 3.3
}