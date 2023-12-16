package extensionproperties

import atomictest.eq


/*
*  확장 프로퍼티를 정의할 경우 커스텀 게터가 필요하다.
* */
val String.indices: IntRange
    get() = 0 until length


fun main() {
    "abc".indices eq 0..2
}

