package manipulatinglists

import Test.eq


class Book(
    val title: String,
    val authors: List<String>
)

fun main() {
    val books = listOf(
        Book("1984", listOf("George Orwell")),
        Book("Ulysses", listOf("James Joyce"))
    )

    /*
    *  map()은 작가의 List의 List를 생성하지만 사용하기 불편하다.
    *  -> flatten()을 적용하면 단순한 List를 얻을 수 있다.
    * */
    books.map { it.authors }.flatten() eq
            listOf("George Orwell", "James Joyce")

    /*
    *  flatMap()은 한 번의 연산으로 위의 예제와 같은 결과를 제공한다.
    * */
    books.flatMap { it.authors } eq
            listOf("George Orwell", "James Joyce")
}