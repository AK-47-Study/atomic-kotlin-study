package Chapter1.`kh-cho`.`khcho-study`.src.main.kotlin.`InKeyword1-13`

fun main() {
    val values = 1..3
    for (v in values){
        println("iteration $v")
    }
    val v = 2
    if (v in values)
        println("$v is a member of $values")
}