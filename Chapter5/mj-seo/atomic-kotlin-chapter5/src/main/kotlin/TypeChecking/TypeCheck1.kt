package typechecking

import Test.eq


interface Shape {
    fun draw(): String
}

class Circle : Shape {
    override fun draw(): String = "Circle: Draw"
}

class Square : Shape {
    override fun draw(): String = "Square: Draw"
    // Square를 회전시키는 rotate() 연산을 굳이 Shape에 추가해서 인터페이스를 복잡하게 만들 필요가 없다.
    fun rotate() = "Square: Rotate"
}

fun turn(s: Shape) = when (s) {
    is Square -> s.rotate()
    else -> ""
}

fun main() {
    val shapes = listOf(Circle(), Square())

    shapes.map { it.draw() } eq
            "[Circle: Draw, Square: Draw]"

    shapes.map(::turn) eq
            "[, Square: Rotate]"
}