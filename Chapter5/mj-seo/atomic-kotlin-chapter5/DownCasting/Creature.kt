package downcasting

import Test.eq


interface Creature

class Human : Creature {
    fun greeting() = "I'm Human"
}

class Dog : Creature {
    fun bark() = "Yip!"
}

class Alien : Creature {
    fun mobility() = "Three legs"
}

fun what(c: Creature): String =
    when (c) {
        // 스마트 캐스트는 is를 통해 when의 인자가 어떤 타입인지 검색하는 when 식 내부에서 아주 유용하다.
        is Human -> c.greeting()
        is Dog -> c.bark()
        is Alien -> c.mobility()
        else -> "Something else"
    }

fun main() {
    // 이미 Human 객체는 Creature로 업캐스트 된 상태이다.
    val c: Creature = Human()

    // what()은 이미 업캐스트된 Creature를 받아서 정확한 타입을 찾고, 더 구체적인 파생 클래스로 다운 캐스트 한다.
    what(c) eq "I'm Human"
    what(Dog()) eq "Yip!"
    what(Alien()) eq "Three legs"

    class Who: Creature
    what(Who()) eq "Something else"
}