package Chapter2.`kh-cho`.`khcho-study`.src.main.kotlin.`Constructors2-4`

class MutableNameAlien(var name:String)

class FixedNameAlien(val name: String)

fun main() {
    val alien1 =
        MutableNameAlien("Reverse Giraffe")
    val alien2 =
        FixedNameAlien("Krombopolis")
    alien1.name = "Parasite"
}