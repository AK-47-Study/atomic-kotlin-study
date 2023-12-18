package Chapter2.`kh-cho`.`khcho-study`.src.main.kotlin.`Constructors2-4`

class Alien(name:String) {
    val greeting = "Poor $name!"
}

fun main() {
    val alien = Alien("Mr. Meeseeks")
    println("alien = ${alien.greeting}")
}