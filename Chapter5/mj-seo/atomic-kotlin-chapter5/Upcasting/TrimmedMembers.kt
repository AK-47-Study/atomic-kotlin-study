package upcasting

import Test.trace


fun trim(shape: Shape) {
    trace(shape.draw())
    trace(shape.erase())

    // 컴파일 되지 않는다 -> Up-Casting을 통해 상위 타입으로 변환되었다.
//    shape.color()
//    shape.rotate()
}

fun main() {
    trim(Square())
    trim(Triangle())

    trace eq """
        Square.draw
        Square.erase
        Triangle.draw
        Triangle.erase
    """.trimIndent()
}