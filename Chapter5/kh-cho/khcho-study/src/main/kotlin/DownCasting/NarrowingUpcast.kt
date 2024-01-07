package Chapter5.`kh-cho`.`khcho-study`.src.main.kotlin.DownCasting

interface Base {
    fun f()
}

class Derived1 : Base {
    override fun f() {}
    fun g() {}
}

class Derived2 : Base {
    override fun f() {}
    fun h(){}
}

fun main() {
    val b1 : Base = Derived1() // 업캐스트
    b1.f() // 기반 클래스의 일부분
    // b1.g() // 기반 클래스에 들어있지 않음
    val b2 : Base = Derived2()
    b2.f()
    //b2.h() // 기반 클래스에 들어있지 않음
}