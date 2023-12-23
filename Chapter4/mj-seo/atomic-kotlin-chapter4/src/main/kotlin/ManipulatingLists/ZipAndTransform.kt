package manipulatinglists

import Test.eq


data class Person(
    val name: String,
    val id: Int
)

fun main() {
    val names = listOf("Bob", "Jill", "Jim")
    val ids = listOf(1731, 9274, 8378)

    // zip() 함수는 만들어진 Pair에 대해 연산을 적용할 수도 있다.
    names.zip(ids) {name, id ->
        Person(name, id)
    } eq "[Person(name=Bob, id=1731), " +
            "Person(name=Jill, id=9274), " +
            "Person(name=Jim, id=8378)]"
}