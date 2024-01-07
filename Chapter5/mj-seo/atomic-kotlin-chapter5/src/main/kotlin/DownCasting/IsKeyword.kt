import downcasting.*


fun main() {
    val b1: Base = Derived1() // 업캐스트

    // 스마트 캐스트는 자동 다운 캐스트이다.
    if (b1 is Derived1) b1.g()

    val b2: Base = Derived2()

    // is 키워드는 어떤 객체가 특정 타입인지 검사한다.
    if (b2 is Derived2) b2.h()
}