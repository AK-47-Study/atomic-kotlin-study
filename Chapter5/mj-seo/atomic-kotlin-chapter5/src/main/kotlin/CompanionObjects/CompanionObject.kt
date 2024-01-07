package companionobjects

import Test.eq


class WithCompanion {
    // 동반 객체의 원소는 일반 클래스의 원소에 접근할 수 있다.
    companion object {
        val i = 3
        fun f() = i * 3
    }
    fun g() = i + f()
}

fun WithCompanion.Companion.h() = f() * i

fun main() {
    val wc = WithCompanion()

    // g()에서 볼 수 있듯이 클래스의 멤버는 동반 객체의 원소에 한정을 사용하지 않고 접근이 가능하다.
    wc.g() eq 12

    WithCompanion.i eq 3
    WithCompanion.f() eq 9
    WithCompanion.h() eq 27
}