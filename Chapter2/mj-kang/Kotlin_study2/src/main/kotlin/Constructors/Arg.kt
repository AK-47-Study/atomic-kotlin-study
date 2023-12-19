package Constructors

class Alien(name: String) {
    val greeting = "good $name"
}

fun main() {
    val alien = Alien("Mr. Hyuk")
    println(alien.greeting)
}