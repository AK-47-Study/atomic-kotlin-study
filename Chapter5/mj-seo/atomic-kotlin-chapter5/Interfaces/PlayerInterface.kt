package interfaces

import Test.eq


interface Player {
    val symbol: Char
}

/*
*  인터페이스가 프로퍼티를 선언할 수도 있다.
*  -> 이런 인터페이스를 구현하는 클래스는 항상 프로퍼티를 오버라이딩 해야 한다.
* */
class Food : Player {
    override val symbol = '.'
}

class Robot : Player {
    override val symbol = 'R'
}

class Wall(override val symbol: Char) : Player

fun main() {
    listOf(Food(), Robot(), Wall('|')).map {
        it.symbol
    } eq "[., R, |]"
}