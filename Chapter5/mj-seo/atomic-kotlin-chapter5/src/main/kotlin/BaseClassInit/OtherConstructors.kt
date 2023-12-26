package baseclassinit

import Test.eq


open class Base(val i: Int)

class Derived: Base {
    // 기반 클래스(부모 클래스)의 생성자를 호출하려면 super 키워드를 적고, 함수를 호출할 때 처럼 생성자 인자를 전달하면 된다.
    constructor(i: Int) : super(i)
    constructor() : this(9)
}

fun main() {
    val d1 = Derived(11)
    d1.i eq 11

    val d2 = Derived()
    d2.i eq 9
}