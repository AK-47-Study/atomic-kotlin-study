package Chapter3.`kh-cho`.`khcho-study`.src.main.kotlin.DataClasses6

import atomictest.eq
import atomictest.neq

class Person(val name: String)
data class Contact(
    val name: String,
    val number: String
)
fun main() {
    Person("Cleo") neq Person("Cleo")
// 데이터 클래스는 타당한 동등성 검사를 제공한다
    Contact("Miffy", "1-234-567890") eq
        Contact("Miffy", "1-234-567890")
}