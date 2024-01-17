package creatinggenerics

import Test.eq


class Person {
    fun speak() = "Hi!"
}

class Dog {
    fun bark() = "Ruff!"
}

class Robot {
    fun communicate() = "Beep!"
}

fun talk(speaker: Any) = when (speaker) {
    is Person -> speaker.speak()
    is Dog -> speaker.bark()
    is Robot -> speaker.communicate()
    // 타입이 추가되면 talk()를 변경하는 것을 놓치면 안된다.
    else -> "Not a talker"
}

fun main() {
    talk(Person()) eq "Hi!"
    talk(Dog()) eq "Ruff!"
    talk(Robot()) eq "Beep!"
    talk(11) eq "Not a talker"
}