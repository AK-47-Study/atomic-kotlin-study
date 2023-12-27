package com.ak47.atomickotlinstudy.Constructors

class MutableNameAlien(var name: String)

class FixedNameAlien(val name: String)

fun main() {
    val alien1 =
            MutableNameAlien("Reverse Giraffe")
    val alien2 =
            FixedNameAlien("Krombopolis Michael")
    alien1.name = "Parasite"
    // 다음과 같이 할 수는 없다
    // alien2.name = "Parasite" // compile error 발생: Val cannot be reassigned
}