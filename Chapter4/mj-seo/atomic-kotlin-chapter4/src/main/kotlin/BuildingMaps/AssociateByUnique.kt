import Test.eq
import buildingmaps.*


fun main() {
    // associateBy()는 키가 유일하지 않은 경우, 원본의 값 중 일부가 사라진다.
    val ages = people().associateBy { it.age }

    ages eq mapOf(
        21 to Person("Franz", 21),
        15 to Person("Arthricia", 15),
        25 to Person("Bill", 25),
        42 to Person("Crocubot", 42),
        33 to Person("Revolio", 33))
}