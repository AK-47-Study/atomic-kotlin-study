package dataclasses

import atomictest.eq

data class DetailedContact(
    val name: String,
    val surname: String,
    val number: String,
    val address: String
)

fun main() {
    val contact = DetailedContact(
        "Miffy",
        "Miller",
        "1-234-567890",
        "1600 Amphitheatre Parkway")

    /*
    *  copy() 파라미터 이름은 생성자 파라미터 이름과 같다.
    *  -> 모든 인자에는 각 프로퍼티의 현재 값이 디폴트 인자로 지정되어 있다.
    *     변경을 원하는 인자만 Named-Argument로 지정하면 된다.
    * */
    val newContact = contact.copy(
        number = "098-765-4321",
        address = "Brandschenkestrasse 110")

    newContact eq DetailedContact(
        "Miffy",
        "Miller",
        "098-765-4321",
        "Brandschenkestrasse 110")
}