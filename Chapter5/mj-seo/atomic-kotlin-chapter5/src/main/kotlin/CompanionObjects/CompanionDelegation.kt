package companionobjects

import Test.trace


class ZIClosed: ZI {
    override fun f() = "ZIClosed.f()"
    override fun g() = "ZIClosed.g()"
}

class ZIDelegation {
    companion object: ZI by ZIClosed()
    fun u() = trace("${f()} ${g()}")
}

class ZIDelegationInheritance {
    // 동반 객체로 사용하고 싶은 클래스가 open이 아니라면, 직접 확장할 수는 없다.
    companion object: ZI by ZIClosed() {
        override fun g() =
            "ZIDelegationInheritance.g()"

        fun h() =
            "ZIDelegationInheritance.h()"
    }
    fun u() = trace("${f()} ${g()} ${h()}")
}

fun main() {
    ZIDelegation.f()
    ZIDelegation.g()
    ZIDelegation().u()
    ZIDelegationInheritance.f()
    ZIDelegationInheritance.g()
    ZIDelegationInheritance().u()
    trace eq """
    ZIClosed.f() ZIClosed.g()
    ZIClosed.f()
    ZIDelegationInheritance.g()
    ZIDelegationInheritance.h()
  """
}
