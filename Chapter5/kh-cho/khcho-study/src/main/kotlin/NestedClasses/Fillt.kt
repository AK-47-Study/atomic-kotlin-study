package Chapter5.`kh-cho`.`khcho-study`.src.main.kotlin.NestedClasses

import Chapter5.`kh-cho`.`khcho-study`.src.main.kotlin.NestedClasses.Game.Mark
import Chapter5.`kh-cho`.`khcho-study`.src.main.kotlin.NestedClasses.Game.Mark.*
import atomictest.eq
import kotlin.random.Random

interface Game{
    enum class State { Playing, Finished}
    enum class Mark { Blank, X, O}
}

class Fillt (
    val side: Int = 3, randomSeed: Int = 0
    ):Game {
    val rand = Random(randomSeed)
    private var state = Game.State.Playing
    private val grid =
        MutableList(side * side) { Blank }
    private var player = X
    fun turn() {
        val blanks = grid.withIndex()
            .filter { it.value == Blank }
        if (blanks.isEmpty()) {
            state = Game.State.Finished
        } else {
            grid[blanks.random(rand).index] = player
            player = if (player == X) O else X
        }
    }

    fun play() {
        while (state != Game.State.Finished)
            turn()
    }

    override fun toString() =
        grid.chunked(side).joinToString("\n")
}
fun main() {
    val game = Fillt(8, 17)
    game.play ()
    game eq """
            [O, X, O, X, 0, X, X, X]
            [X, O, X, X, X, O, X, X]
            """
}