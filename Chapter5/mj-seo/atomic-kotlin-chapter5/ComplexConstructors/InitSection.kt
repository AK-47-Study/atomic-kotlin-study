package complexconstructors

import Test.eq


private var counter = 0

// 생성자 파라미터에 var이나 val이 붙어있지 않더라도 init 블럭에서 사용할 수 있다.
class Message(text: String) {
    private val content: String

    // init 블록은 클래스 본문에 정의된 순서대로 실행된다 -> 여러 개 둘 수 있다.
    init {
        counter += 10
        content = "[$counter] $text"
    }

    override fun toString() = content
}

fun main() {
    val m1 = Message("Big ba-da boom!")
    m1 eq "[10] Big ba-da boom!"

    val m2 = Message("Bzzzzt!")
    m2 eq "[20] Bzzzzt!"
}