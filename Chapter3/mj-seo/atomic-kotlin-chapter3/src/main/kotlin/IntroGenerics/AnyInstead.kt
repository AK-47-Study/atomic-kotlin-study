package introgenerics

import atomictest.eq


/*
*  모든 타입의 부모 타입인 Any를 사용하면 문제가 해결 될 것 같지만,
*  구체적인 타입이 필요해지면 Any 타입으로 대입한 객체 타입이 어떤 타입인지
*  더 이상 추적이 불가능하다.
* */
class AnyHolder(private val value: Any) {
    fun getValue(): Any = value
}

class Dog {
    fun bark() = "Ruff!"
}

fun main() {
    val holder = AnyHolder(Dog())
    val any = holder.getValue()

    // 컴파일 오류 발생
//    any.bark()

    /*
    *  제네릭스를 사용하면 실제 컬렉션에 Dog를 담고 있다는 정보를 유지할 수 있다.
    * */
    val genericHolder = GenericHolder(Dog())
    val dog = genericHolder.getValue()
    dog.bark() eq "Ruff!"
}