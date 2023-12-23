import Test.eq
import buildingmaps.*


fun main() {
    val map: Map<Person, String> =
        people().associateWith { it.name }

    /*
    *  associateWith()를 사용하면 리스트 원소를 키로 하고,
    *  associateWith()에 전달된 함수를 리스트 원소에 적용한 반환값을 값으로 하는
    *  Map을 만들 수 있다.
    *  -> Map의 Key-> Person 객체, Value-> Person의 이름
    * */
    map eq mapOf(
        Person("Alice", 21) to "Alice",
        Person("Arthricia", 15) to "Arthricia",
        Person("Bob", 25) to "Bob",
        Person("Bill", 25) to "Bill",
        Person("Birdperson", 42) to "Birdperson",
        Person("Charlie", 21) to "Charlie",
        Person("Crocubot", 42) to "Crocubot",
        Person("Franz", 21) to "Franz",
        Person("Revolio", 33) to "Revolio"
    )
}