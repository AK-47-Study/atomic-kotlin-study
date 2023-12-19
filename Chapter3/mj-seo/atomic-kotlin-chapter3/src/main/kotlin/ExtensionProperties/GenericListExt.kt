package extensionproperties

import atomictest.eq


/*
*  기능이 단순하고 가독성을 향상시키는 경우에만 프로퍼티를 권장한다.
* */
val <T> List<T>.firstOrNull: T?
    get() = if (isEmpty()) null else this[0]

fun main() {
    listOf(1, 2, 3).firstOrNull eq 1
    listOf<String>().firstOrNull eq null
}