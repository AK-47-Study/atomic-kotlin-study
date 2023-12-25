package interfaces

import Test.eq


interface Computer {
    fun prompt(): String
    fun calculateAnswer(): Int
}

// 인터페이스를 구현한 클래스를 정의하려면, 클래스 이름 뒤에 콜론(:)과 인터페이스 이름을 넣으면 된다.
class Desktop: Computer {
    override fun prompt() = "Hello!"

    override fun calculateAnswer() = 11
}

class DeepThought: Computer {
    override fun prompt() = "Thinking...!"

    override fun calculateAnswer() = 42
}

class Quantum: Computer {
    override fun prompt() = "Probably..."

    override fun calculateAnswer() = -1
}

fun main() {
    val computers = listOf(
        Desktop(), DeepThought(), Quantum()
    )

    computers.map { it.calculateAnswer() } eq
            "[11, 42, -1]"

    computers.map { it.prompt() } eq
            "[Hello!, Thinking...!, Probably...]"
}

