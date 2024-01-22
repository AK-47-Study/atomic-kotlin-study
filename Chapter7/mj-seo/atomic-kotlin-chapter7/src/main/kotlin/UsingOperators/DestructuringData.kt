package usingoperators

import Test.eq


data class Person(
    val name: String,
    val age: Int
) {
    // 컴파일러가 component1()과 component2()를 만들어준다.
}

fun main() {
    val person = Person("Alice", 29)
    val (name, age) = person

    // 구조 분해 대입은 원래는 함수 호출로 처리할 수 있다.
    val name_ = person.component1()
    val age_ = person.component2()

    name eq "Alice"
    age eq 29

    name_ eq "Alice"
    age_ eq  29
}