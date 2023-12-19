package Chapter2.`kh-cho`.`khcho-study`.src.main.kotlin.`Constructors2-4`

class Scientist(val name: String) {
    override fun toString(): String {
        return "Scientist('$name')"
    }
}

fun main() {
    val zeep = Scientist("Zeep Xanflorp")
    println(zeep)
}