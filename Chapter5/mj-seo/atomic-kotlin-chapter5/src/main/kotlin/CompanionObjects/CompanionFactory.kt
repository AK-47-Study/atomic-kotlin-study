package companionobjects

import Test.eq


class Numbered2

private constructor(private val id: Int) {
    override fun toString() = "#$id"
    // 동반 객체를 이용해 팩토리 메서드 패턴 구현이 가능하다.
    companion object Factory {
        fun create(size: Int) =
            List(size) { Numbered2(it) }
    }
}

fun main() {
    Numbered2.create(0) eq "[]"
    Numbered2.create(5) eq
            "[#0, #1, #2, #3, #4]"
}