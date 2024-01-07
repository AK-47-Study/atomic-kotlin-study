package typechecking

import Test.eq


class Triangle : Shape {
    override fun draw() = "Triangle: Draw"
    fun rotate() = "Triangle: Rotate"
}

/*
*  시스템의 모든 타입을 검사한다는 뜻에서,
*  이런 코드 스타일을 타입 검사 코딩이라고 부른다.
* */
fun turn2(s: Shape) = when (s) {
    is Square -> s.rotate()
    is Triangle -> s.rotate()
    else -> ""
}

fun main() {
    val shapes =
        listOf(Circle(), Square(), Triangle())

    shapes.map { it.draw() } eq
            "[Circle: Draw, Square: Draw, Triangle: Draw]"

    shapes.map(::turn) eq
            "[, Square: Rotate, ]"

    shapes.map(::turn2) eq
            "[, Square: Rotate, Triangle: Rotate]"
}