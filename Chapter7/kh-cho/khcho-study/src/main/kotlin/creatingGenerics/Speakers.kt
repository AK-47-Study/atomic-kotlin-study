package Chapter7.`kh-cho`.`khcho-study`.src.main.kotlin.creatingGenerics

import atomictest.eq

class Person{
    fun speak() = "Hi!"
}

class Dog{
    fun bark() = "Ruff!"
}

class Robot{
    fun communicate() = "Beep!"
}

fun talk(speaker: Any) = when(speaker) {
    is Person -> speaker.speak()
    is Dog -> speaker.bark()
    is Robot -> speaker.communicate()
    else -> "Not a talker"
}

fun main() {
    talk(Person()) eq "Hi!"
    talk(Dog()) eq "Ruff!"
    talk(Robot()   ) eq  "Beep!"
    talk(11) eq "Not a talker"
}