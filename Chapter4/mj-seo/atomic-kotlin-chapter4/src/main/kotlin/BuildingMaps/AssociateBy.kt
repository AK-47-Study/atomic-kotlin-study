import Test.eq
import buildingmaps.*


fun main() {
    /*
    *  associateBy()는 associateWith()와 반대의 결과를 만든다.
    *  -> Map의 Key -> Person의 이름, Value -> Person 객체
    * */
    val map: Map<String, Person> =
        people().associateBy { it.name }

    map eq mapOf(
        "Alice" to Person("Alice", 21) ,
        "Arthricia" to Person("Arthricia", 15),
        "Bob" to Person("Bob", 25),
        "Bill" to Person("Bill", 25),
        "Birdperson" to Person("Birdperson", 42),
        "Charlie" to Person("Charlie", 21),
        "Crocubot" to Person("Crocubot", 42),
        "Franz" to Person("Franz", 21),
        "Revolio" to Person("Revolio", 33)
    )
}