package objects

import Test.eq

// object에 대해서는 파라미터 목록을 지정할 수는 없다.
object JustOne {
    val n = 2
    fun f() = n * 10
    fun g() = this.n * 20
}

fun main() {

    // object의 인스턴스를 직접 생성하는 경우는 결코 없다.
//    val x = JustOne()

    JustOne.n eq 2
    JustOne.f() eq 20
    JustOne.g() eq 40
}