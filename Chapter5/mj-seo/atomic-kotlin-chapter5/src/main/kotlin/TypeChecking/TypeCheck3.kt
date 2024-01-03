package typechecking3

import Test.eq
import typechecking.name


/*
*  인터페이스는 sealed가 될 수 없으므로 클래스로 선언해야 한다.
*  -> turn()이 else 절을 사용하지 않으므로 실수로 타입을 추가하지 않아도, 컴파일 에러가 발생한다.
* */
sealed class Shape {
    fun draw() = "$name: Draw"
}

class Circle : Shape()

class Square : Shape() {
    fun rotate() = "Square: Rotate"
}

class Triangle : Shape() {
    fun rotate() = "Triangle: Rotate"
}

fun turn(s: Shape) = when (s) {
    is Circle -> ""
    is Square -> s.rotate()
    is Triangle -> s.rotate()
}

fun main() {
    val shapes = listOf(Circle(), Square())

    shapes.map { it.draw() } eq
            "[Circle: Draw, Square: Draw]"

    shapes.map(::turn) eq
            "[, Square: Rotate]"
}