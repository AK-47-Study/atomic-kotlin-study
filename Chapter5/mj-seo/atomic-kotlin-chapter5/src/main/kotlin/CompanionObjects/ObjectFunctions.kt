package companionobjects

import Test.eq


class CompanionObjectFunction {
    companion object {
        // 어떤 함수가 동반 객체의 프로퍼티만 사용한다면 동반 객체로 옮기는 것이 타당하다.
        private var n: Int = 0
        fun increment() = ++n
    }
}

fun main() {
    CompanionObjectFunction.increment() eq 1
    CompanionObjectFunction.increment() eq 2
}