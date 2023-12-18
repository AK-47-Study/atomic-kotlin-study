package Chapter1.`kh-cho`.`khcho-study`.src.main.kotlin.`InKeyword1-13`

fun main() {
    println(isDigit('a'))
    println(isDigit('5'))
    println(isDigit('z'))
}

fun isDigit(ch: Char) = ch in '0' .. '9'

