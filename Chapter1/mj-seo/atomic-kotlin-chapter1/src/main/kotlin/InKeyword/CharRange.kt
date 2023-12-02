package InKeyword

/*
*  문자의 범위안에 속하는지 여부도 in 연산자로 검색할 수 있다.
* */
fun isDigit(ch: Char) = ch in '0'..'9'

fun notDigit(ch: Char) = ch !in '0'..'9'

fun main() {
    println(isDigit('a'))
    println(isDigit('5'))
    println(notDigit('z'))
}