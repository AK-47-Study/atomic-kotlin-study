package Chapter5.`kh-cho`.`khcho-study`.src.main.kotlin.NestedClasses

interface Amphibian
fun createAmphibian() : Amphibian {
    class Frog : Amphibian
    return Frog()
}

fun main() {
    val amphibian = createAmphibian()
}