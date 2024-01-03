package Chapter3.`kh-cho`.`khcho-study`.src.main.kotlin.Enumerations5

import atomictest.eq

enum class Direction(val notation: String) {
    North("N"), South("S"),
    East("E"), West("W"); // 세미콜론이 꼭 필요함

    val opposite: Direction
        get() = when (this) {
            North -> South
            South -> North
            West -> East
            East -> West
        }
}
fun main() {
    Direction.North.notation eq "N"
    Direction.North.opposite eq Direction.South
    Direction.West.opposite.opposite eq Direction.West
    Direction.North.opposite.notation eq "S"
}
