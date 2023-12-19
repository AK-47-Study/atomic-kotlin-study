package Chapter1.`kh-cho`.`khcho-study`.src.main.kotlin.`Booleans1-10`

fun main() {
    isOpen1(6)
}

fun isOpen1(hour: Int) {
    val open = 9
    val closed = 20
    println("Operating hours : $open - $closed")
    val status =
        if (hour >= open && hour <= closed)
            true
        else
            false
    println("Open: $status")
}
