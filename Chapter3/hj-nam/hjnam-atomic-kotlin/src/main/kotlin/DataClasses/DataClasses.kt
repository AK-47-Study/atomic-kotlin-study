package dataclsses
import atomictest.*

class Person(val name: String)

data class Contact(
    val name: String,
    val number: String
)

fun main() {
    // 아래 둘은 같아 보이지만 아님
    Person("Cleo") neq Person("Cleo")
    // 데이터 클래스는 타당한 동등성 검사를 제공
    Contact("Miffy", "1-234-567890") eq
            Contact("Miffy", "1-234-567890")
}