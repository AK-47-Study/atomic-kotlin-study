package Chapter2.`kh-cho`.`khcho-study`.src.main.kotlin.`Varargs2-10`

fun v(s: String, vararg d: Double) {}
fun main() {
    v("abc1", 1.0, 2.0)
    v("def11", 1.0, 2.0, 3.0, 4.0)
    v("ghiuz", 1.0, 2.0, 3.0, 4.0, 5.0, 6.0)
}