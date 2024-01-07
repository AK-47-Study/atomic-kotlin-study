package nestedclasses
import Test.eq
import kotlin.random.Random
import nestedclasses.Game.Mark.*
import nestedclasses.Game.State.*

interface Game {
    enum class State { Playing, Finished }
    enum class Mark { Blank, X, O }
}

class Fillit(
    val side: Int = 3, randomSeed: Int = 0
): Game {
    val rand = Random(randomSeed)
    private var state = Playing
    private val grid = MutableList(side * side) { Blank }
    private var player = X

    private fun turn() {
        val blanks = grid.withIndex()
            .filter { it.value == Blank }

        if (blanks.isEmpty()) {
            state = Finished
        } else {
            grid[blanks.random(rand).index] = player
            player = if (player == X) O else X
        }
    }

    fun play() {
        while (state != Finished)
            turn()
    }
    override fun toString() =
        // List를 2차원 격자로 표현하려면, chunked()를 이용해 특정 길이의 여러 조각으로 분할하고, 개행 문자를 이용하면 된다.
        grid.chunked(side).joinToString("\n")
}

fun main() {
    val game = Fillit(8, 17)
    game.play()

    game eq """
      [O, X, O, X, O, X, X, X]
      [X, O, O, O, O, O, X, X]
      [O, O, X, O, O, O, X, X]
      [X, O, O, O, O, O, X, O]
      [X, X, O, O, X, X, X, O]
      [X, X, O, O, X, X, O, X]
      [O, X, X, O, O, O, X, O]
      [X, O, X, X, X, O, X, X]
    """.trimIndent()
}