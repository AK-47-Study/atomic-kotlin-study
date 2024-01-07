package companionobjects

import Test.trace


class CompanionInit {
    companion object {
        init {
            // 동반 객체 생성이 동반 클래스 생성자 생성보다 더 먼저 이뤄진다.
            trace("Companion Constructor")
        }
    }
}

fun main() {
    trace("Before")
    CompanionInit()
    trace("After 1")
    CompanionInit()
    trace("After 2")
    CompanionInit()
    trace("After 3")
    trace eq """
    Before
    Companion Constructor
    After 1
    After 2
    After 3
  """
}


