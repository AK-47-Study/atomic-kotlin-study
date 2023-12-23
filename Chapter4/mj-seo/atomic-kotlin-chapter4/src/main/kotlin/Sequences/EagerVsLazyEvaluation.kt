package sequences

import Test.trace


fun Int.isEven(): Boolean {
    trace("$this.isEven()")
    return this % 2 == 0
}

fun Int.square(): Int {
    trace("$this.square()")
    return this * this
}

fun Int.lessThanTen(): Boolean {
    trace("$this.lessThanTen()")
    return this < 10
}

fun main() {
    val list = listOf(1, 2, 3, 4)
    trace(">>> List:")
    trace(
        list
            .filter(Int::isEven)
            .map(Int::square)
            .any(Int::lessThanTen)
    )
    trace(">>> Sequence:")

    /*
    *  지연 연산을 사용하면, 어떤 원소와 연관된 값이 진짜 필요할 때만 그 원소와 관련된
    *  연산을 수행한다.
    *  -> Java의 Stream과 거의 같다.
    * */
    trace(
        list.asSequence()
            .filter(Int::isEven)
            .map(Int::square)
            .any(Int::lessThanTen)
    )

    trace eq """
        >>> List:
        1.isEven()
        2.isEven()
        3.isEven()
        4.isEven()
        2.square()
        4.square()
        4.lessThanTen()
        true
        >>> Sequence:
        1.isEven()
        2.isEven()
        2.square()
        4.lessThanTen()
        true
    """.trimIndent()
}