import Test.eq
import buildingmaps.*


fun main() {
    val groups = people().groupBy { it.name.first() }

    // groupBy()는 Map을 빠르게 생성한다.
    groups['A'] eq listOf(
        Person("Alice", 21),
        Person("Arthricia", 15))

    groups['Z'] eq null

    // filter()를 사용하면 각 문자에 대해 filter를 반복 실행해야 한다.
    people().filter {
        it.name.first() == 'A'
    } eq listOf(
        Person("Alice", 21),
        Person("Arthricia", 15))

    people().filter {
        it.name.first() == 'F'
    } eq listOf(Person("Franz", 21))

    // partition() 함수를 사용하면 컬렉션 내용을 두 그룹으로 나눠준다.
    people().partition {
        it.name.first() == 'A'
    } eq Pair(
        listOf(
            Person("Alice", 21),
            Person("Arthricia", 15)),
        listOf(Person("Bob", 25),
            Person("Bill", 25),
            Person("Birdperson", 42),
            Person("Charlie", 21),
            Person("Crocubot", 42),
            Person("Franz", 21),
            Person("Revolio", 33)))
}