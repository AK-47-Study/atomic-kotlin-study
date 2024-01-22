package Chapter5.`kh-cho`.`khcho-study`.src.main.kotlin.TypeChecking

import atomictest.eq

interface Shape{
    fun draw(): String
}

class Circle : Shape{
    override fun draw() = "Circle : Draw"
}

class Square: Shape{
    override fun draw( ) = "Square: Draw"
    fun rotate() = "Square : Rotate"
}

fun turn(s: Shape) = when(s){
    is Square -> s.rotate()
    else -> ""
}

fun main() {
    val shape = listOf(Circle(), Square())
    shape.map { it.draw() } eq
            "[Circle: Draw, Square, Draw]"
    shape.map { turn(it) } eq
            "[, Square: Rotate]"
}