package Chapter2.`kh-cho`.`khcho-study`.src.main.kotlin.Properties

class Kitchen{
    var table: String = "Round table"
}

fun main() {
    val kitchen1 = Kitchen()
    val kitchen2 = Kitchen()
    println("kitchen1.table = ${kitchen1.table}")
    println("kitchen1.table = ${kitchen2.table}")
    kitchen1.table = "Square table"
    println("kitchen1.table = ${kitchen1.table}")
    println("kitchen1.table = ${kitchen2.table}")
}