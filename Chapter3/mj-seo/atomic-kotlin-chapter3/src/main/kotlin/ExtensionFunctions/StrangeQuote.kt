package extensionfunctions

import atomictest.eq


fun String.strangeQuote() =
    /*
    *  확장 함수 안에서도 this를 생략할 수 있다.
    *  -> 명시적으로 멤버를 한정시킬 필요가 없다.
    * */
    this.singleQuote().singleQuote()

fun String.tooManyQuotes() =
    doubleQuote().doubleQuote()

fun main() {
    "Hi".strangeQuote() eq "''Hi''"
    "Hi".tooManyQuotes() eq "\"\"Hi\"\""
}