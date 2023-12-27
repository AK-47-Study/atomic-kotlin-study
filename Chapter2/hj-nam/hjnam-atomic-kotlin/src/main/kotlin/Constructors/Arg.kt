package com.ak47.atomickotlinstudy.Constructors

class Alien(name: String) {
    val greeting = "Poor $name!"
}

fun main() {
    val alien = Alien("Mr. Meeseeks") // 인자를 지정하지 않으면 compile error 발생
    println(alien.greeting)
    // alien.name // Error // [1]
}