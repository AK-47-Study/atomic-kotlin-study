package Chapter2.`kh-cho`.`khcho-study`.src.main.kotlin.`Maps2-12`

import atomictest.eq

class Contact(
    val name : String,
    val phone : String
) {
    override fun toString(): String{
        return "Contact('$name', '$phone')"
    }
}
fun main() {
    val miffy = Contact("Miffy","1-234-56678")
    val cleo = Contact("Cleo", "163-1234-1234")
    val contacts = mapOf(
        miffy.phone to miffy,
        cleo.phone to cleo)
    contacts["1-234-56678"] eq miffy
    contacts["163-1234-1234"] eq null
}