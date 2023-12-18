package Chapter2.`kh-cho`.`khcho-study`.src.main.kotlin.Properties

class Cup {
    var percentFul = 0
}

fun main() {
    val c1 = Cup()
    c1.percentFul = 50
    val c2 = Cup()
    c2.percentFul = 100

    println("c1 = ${c1.percentFul}")
    println("c1 = ${c2.percentFul}")
}