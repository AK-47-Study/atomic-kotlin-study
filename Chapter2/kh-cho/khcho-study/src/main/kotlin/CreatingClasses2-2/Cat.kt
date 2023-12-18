package Chapter2.`kh-cho`.`khcho-study`.src.main.kotlin.`CreatingClasses2-2`

fun main() {
    val cat = Cat()
    val m1 = cat.meow()
    println(m1)
}

class Cat {
    fun meow() = "mrrrow!"
}