package abstractclasses

import Test.eq


interface PropertyAccessor {
    // 내부에 정의된 프로퍼티가 상태를 바꿀 수 없는 경우에는 인터페이스도 프로퍼티의 커스텀 게터를 포함할 수 있다.
    val a: Int
        get() = 11
}

class Impl : PropertyAccessor

fun main() {
    Impl().a eq 11
}

