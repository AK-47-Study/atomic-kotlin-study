package Chapter5.`kh-cho`.`khcho-study`.src.main.kotlin.TypeChecking

import atomictest.eq

sealed class Shapes{
    fun draw() = "$name: Draw"
}

class Circles: Shapes()

class Squares : Shapes() {
    fun rotate() = "Squares: Rotate"
}
class Triangles: Shapes(){
    fun rotate() = "Triangle: Rotate"
}

fun turn(s: Shapes) = when(s) {
    is Circles ->""
    is Squares -> s.rotate()
    is Triangles -> s.rotate()
}

fun main() {
    val shapes = listOf(
        Circles(), Squares()
    )
    shapes.map { it.draw() } eq
            "[Circle : Draw, Square: Draw"
    shapes.map { turn(it) } eq
            "[, Square: Rotate]"
}