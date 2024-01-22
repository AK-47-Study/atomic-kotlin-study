package usingoperators

import Test.eq


/*
*  Comparable 인터페이스를 구현해도, ==과 !=는 포함되지 않는다.
*/
data class Contact(
    val name: String,
    val mobile: String
) : Comparable<Contact> {
    override fun compareTo(other: Contact) =
        name.compareTo(other.name)
}

fun main() {
    val alice = Contact("Alice", "0123456789")
    val bob = Contact("Bob", "9876543210")
    val carl = Contact("Carl", "5678901234")

    (alice < bob) eq true
    (alice <= bob) eq true
    (alice > bob) eq false
    (alice >= bob) eq false

    val contacts = listOf(bob, carl, alice)
    contacts.sorted() eq
            listOf(alice, bob, carl)

    contacts.sortedDescending() eq
            listOf(carl, bob, alice)
}