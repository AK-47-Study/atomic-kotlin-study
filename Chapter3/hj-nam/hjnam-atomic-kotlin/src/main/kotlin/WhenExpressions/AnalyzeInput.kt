package whenexpressions
import atomictest.*

class Coordinates {
    var x: Int = 0
        set(value) {
            trace("x gets $value")
            field  = value
        }
    var y: Int = 0
        set(value) {
            trace("y gets $value")
            field = value
        }

    override fun toString() = "($x, $y)"
}

fun processInputs(inputs: List<String>) {
    val coordinates = Coordinates()
    for (input in inputs) {
        when (input) { // 매치 내용을 콤마를 써서 여러 값을 나열 가능
            "up", "u" -> coordinates.y--
            "down", "d" -> coordinates.y++
            "left", "l" -> coordinates.x--
            "right", "r" -> {
                trace("Moving right")
                coordinates.x++
            }
            "nowhere" -> {} // 아무 일도 하지 않음을 빈 중괄호({})로 표시
            "exit" -> return
            else -> trace("bad input: $input")
        }
    }
}

fun main() {
    processInputs(listOf("up", "d", "nowhere",
        "left", "right", "exit", "r"))
    trace eq """
        y gets -1
        y gets 0
        x gets -1
        Moving right
        x gets 0
    """
}