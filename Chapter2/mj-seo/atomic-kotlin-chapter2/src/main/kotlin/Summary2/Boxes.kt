package summary2

import atomictest.trace


/*
*  Kotlin은 private 최상위 정의를 다른 파일에서 볼 수 없게 한다.
* */
private var count = 0

private class Box(val dimension: Int) {
    fun volume() =
        dimension * dimension * dimension

    override fun toString(): String =
        "Box volume: ${volume()}"
}

private fun countBox(box: Box) {
    trace("$box")
    count++
}

fun countBoxes() {
    countBox(Box(4))
    countBox(Box(5))
}

fun main() {
    countBoxes()
    trace("$count boxes")
    trace eq """
        Box volume: 64
        Box volume: 125
        2 boxes
    """.trimIndent()
}