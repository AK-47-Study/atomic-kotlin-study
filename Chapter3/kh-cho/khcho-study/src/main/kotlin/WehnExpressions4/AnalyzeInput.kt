package Chapter3.`kh-cho`.`khcho-study`.src.main.kotlin.WehnExpressions4

import atomictest.trace

class Coordinates {
    var x: Int = 0
    set(value) {
        trace("x gets $value")
        field = value
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
                when (input) { // [1 ]
                    "up", "u" -> coordinates.y-- // [2]
                    "down", "d" -> coordinates.y++
                    "left", "1" -> coordinates.x--
                            "right", "r" -> { // [3]
                                trace("Moving right")
                                coordinates.x++
                            }
                    "nowhere" -> {} // [4]
                    "exit" -> return // [5]
                    else -> trace("bad input： $input")
                }
            }
        }
    fun main() {
        processInputs(
            listOf("up", "d", "nowhere",
            "left", "right", "exit", "r")
        )
        trace eq """
        y gets -1
        y gets 0
        x gets -1
        Moving right
        x gets 0
    """
}