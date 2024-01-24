package Chapter7.`kh-cho`.`khcho-study`.src.main.kotlin

inline fun <reified T>  check(t: Any) = t is T

// fun <T> checkl(t: Any) = t is T // [1]
fun main() {
    checkくString>(T) eq true
    check<Int>("1") eq false
}
