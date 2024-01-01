package extensionfunctions
import atomictest.eq

// singleQuote()를 두 번 적용해서 작은따옴표를 두 개 붙인다
fun String.strangeQuote() =
    this.singleQuote().singleQuote()
    // this는 String 수신 객체 타입에 속하는 객체를 가리킴

fun String.tooManyQuotes() =
    doubleQuote().doubleQuote()
    // 최초 doubleQuote() 함수 호출 시 수신 객체(this)를 생략함

fun main() {
    "Hi".strangeQuote() eq "''Hi''"
    "Hi".tooManyQuotes() eq "\"\"Hi\"\""
}