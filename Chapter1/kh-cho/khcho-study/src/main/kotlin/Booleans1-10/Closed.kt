package Chapter1.`kh-cho`.`khcho-study`.src.main.kotlin.`Booleans1-10`

fun main() {
    isClosed(6)
}

fun isClosed(hour: Int) {
    val open = 9
    val closed = 20
    println("Operating hours: $open - $closed")
    val status = hour < open || hour > closed
    println("Closed: $status")
}
