package extensionfunctions

import atomictest.eq

/*
*  fun 수신타입.확장함수() { ... }
*  -> 형식으로 확장 함수를 정의할 수 있다.
* */
fun String.singleQuote() = "'$this'"
fun String.doubleQuote() = "\"$this\""

fun main() {
    "Hi".singleQuote() eq "'Hi'"
    "Hi".doubleQuote() eq "\"Hi\""
}