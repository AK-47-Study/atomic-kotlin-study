package upcasting

import atomictest.trace


fun trim(shape: Shape) {
    trace(shape.draw())
    trace(shape.erase())

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

