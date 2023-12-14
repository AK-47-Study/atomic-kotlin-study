package Chapter1.`kh-cho`.`khcho-study`.src.main.kotlin.`Booleans1-10`

fun main() {
    isOpen2(6)
}

fun isOpen2(hour: Int) {
    val open = 9
    val closed = 20
    println("Operating hours : $open - $closed")
    val status = hour >= open && hour <= closed
    println("Open: $status")
}
