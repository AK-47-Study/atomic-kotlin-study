package higherorderfunctions

import atomictest.eq


fun <T> List<T>.any(
    predicate: (T) -> Boolean
): Boolean {
    for (element in this) {
        if (predicate(element))
            return true
    }

    return false
}

fun main() {
    val ints = listOf(1, 2, -3)
    /*
    *  함수가 함수 파라미터를 받는 경우 해당 인자로 람다나 함수 참조를 전달할 수 있다.
    * */
    ints.any { it > 0 } eq true

    val strings = listOf("abc", " ")
    strings.any { it.isBlank() } eq true

    strings.any(String::isNotBlank) eq true
}