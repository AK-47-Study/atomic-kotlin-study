package Chapter5.`kh-cho`.`khcho-study`.src.main.kotlin.NestedClasses

fun localClasses(){
    open class Amphibian
    class Frog : Amphibian()
    val amphibian : Amphibian = Frog()
}