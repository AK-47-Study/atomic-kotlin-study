package companionobjects

import Test.eq


/*
*  동반 객체 안에서 프로퍼티를 생성하면 해당 필드는 메모리상에 단 하나만 존재한다.
*  동반 객체와 연관된 클래스의 모든 인스턴스가 이 필드를 공유한다.
*/
class WithObjectProperty {
    companion object {
        private var n: Int = 0 // 단 하나마나 생긴다.
    }
    fun increment() = ++n
}

fun main() {
    val a = WithObjectProperty()
    val b = WithObjectProperty()

    // increment()는 동반 객체를 둘러싼 private 멤버에 접근 가능하다.
    a.increment() eq 1
    b.increment() eq 2
    a.increment() eq 3
}