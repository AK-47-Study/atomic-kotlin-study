package sealedclasses

import Test.eq


sealed class Transport

data class Train(
    val line: String
) : Transport()


data class Bus(
    val number: String,
    val capacity: Int
) : Transport()

fun travel(transport: Transport) =
    /*
    *  Selaed 클래스를 직접 상속한 하위 클래스는 반드시 기반 클래스와 같은 패키지와 모듈 안에 있어야 한다.
    *  -> Transport가 sealed이기 때문에 코틀린이 다른 Transport의 하위 클래스가 존재할 수 없다는 것을 확신할 수 있기 때문에
    *     else 가지가 필요없다.
    * */
    when (transport) {
        is Train -> "Train ${transport.line}"
        is Bus -> "Bus ${transport.number}: size ${transport.capacity}"
    }

fun main() {
    listOf(Train("S1"), Bus("11", 90))
        .map(::travel) eq
            "[Train S1, Bus 11: size 90]"
}

