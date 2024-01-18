package operatoroverloading

import Test.eq

/*
*  문법적으로는 오류가 없는 코드지만, 코드를 읽는 사람에게는 최악의 코드이다.
*  -> 연산자 오버로딩은 프로그램의 의미를 이해하기 어렵도록 만들 수 있으므로, 조심해서 취급해야 한다.
*/
infix fun String.`#!%`(s: String) =
    "$this Rowzafrazaca $s"

fun main() {
    "howdy" `#!%` "Ma'am!" eq
            "howdy Rowzafrazaca Ma'am!"
}