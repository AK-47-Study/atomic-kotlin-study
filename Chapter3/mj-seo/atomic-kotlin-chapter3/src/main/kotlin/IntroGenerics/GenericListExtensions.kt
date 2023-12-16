package introgenerics

import atomictest.eq


/*
*  제네릭 함수로 정의한 컬렉션 확장 함수는
*  이 함수가 정의된 컬렉션은 어떤 타입을 가져도 사용할 수 있다.
* */
fun <T> List<T>.first(): T {
    if (isEmpty())
        throw NoSuchElementException("Empty List")
    return this[0]
}

fun <T> Set<T>.printAll() {
    for (element in this) {
        println(element)
    }
}

fun <T> List<T>.firstOrNull(): T? =
    if (isEmpty()) null else this[0]

fun main() {
    listOf(1, 2, 3).first() eq 1

    val i: Int? =
        listOf(1, 2, 3).firstOrNull()
    i eq 1

    val s: String? =
        listOf<String>().firstOrNull()
    s eq null

    val set = setOf(1, 2, 3)
    set.printAll()
}