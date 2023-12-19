package summary2

import atomictest.eq


class Cell {
    var entry = ' '
    fun setValue(e: Char): String =
        if (entry == ' ' &&
            (e == 'X' || e == '0')) {
            entry = e
            "Successful move"
        } else
            "Invalid move"
}

class Grid {
    val cells = listOf(
        listOf(Cell(), Cell(), Cell()),
        listOf(Cell(), Cell(), Cell()),
        listOf(Cell(), Cell(), Cell())
    )

    fun play(e: Char, x: Int, y: Int): String =
        if (x !in 0..2 || y !in 0..2)
            "Invalid move"
        else
            cells[x][y].setValue(e)
}

fun main() {
    val grid = Grid()
    grid.play('X', 1, 1) eq "Successful move"
    grid.play('X', 1, 1) eq "Invalid move"
    grid.play('0', 1, 3) eq "Invalid move"
}