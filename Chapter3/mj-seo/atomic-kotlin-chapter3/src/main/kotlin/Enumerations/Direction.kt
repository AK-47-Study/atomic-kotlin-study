package enumerations
import atomictest.eq
import enumerations.Direction.*

enum class Direction(val notation: String) {
    North("N"), South("S"),
    East("E"), West("W");


    val opposite: Direction
        /*
        *  가능한 모든 enum 값을 처리하고 있으므로, when 식에서
        *  else가 없어도 문제가 생기지 않는다.
        *  -> Enum은 코드 가독성을 높여주므로 항상 사용하는 것이 바람직하다.
        * */
        get() = when (this) {
            North -> South
            South -> North
            West -> East
            East -> West
        }
}

fun main() {
    North.notation eq "N"
    North.opposite eq South
    West.opposite.opposite eq West
    North.opposite.notation eq "S"
}