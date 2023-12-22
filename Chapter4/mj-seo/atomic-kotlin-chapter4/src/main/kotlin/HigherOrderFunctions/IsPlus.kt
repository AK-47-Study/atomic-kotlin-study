package higherorderfunctions

import Test.eq


val isPlus: (Int) -> Boolean = { it > 0 }
val isContains: (String) -> Boolean = { it.contains("A") }

fun main() {
    /*
    *  any는 파라미터 값으로 Predicate를 받으므로,
    *  Boolean 값을 반환하는 함수라면 넣을 수 있다.
    * */
    listOf(1, 2, -3).any(isPlus) eq true
    listOf("ABC", "CB", "CCC").any(isContains) eq true
}