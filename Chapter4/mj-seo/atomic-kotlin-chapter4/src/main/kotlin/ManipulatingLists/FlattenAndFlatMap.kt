import Test.eq


fun main() {
    val intRange = 1..3

    intRange.map { a ->
        intRange.map { b -> a to b }
    } eq "[" +
            "[(1, 1), (1, 2), (1, 3)], " +
            "[(2, 1), (2, 2), (2, 3)], " +
            "[(3, 1), (3, 2), (3, 3)]" +
            "]"

    // flatten() 함수를 사용해서 결과를 평평하게 할 수 있다.
    intRange.map { a ->
        intRange.map { b -> a to b }
    }.flatten() eq "[" +
            "(1, 1), (1, 2), (1, 3), " +
            "(2, 1), (2, 2), (2, 3), " +
            "(3, 1), (3, 2), (3, 3)" +
            "]"

    // flatMap() 함수는 map() + flatten() 연산을 한 번에 수행한다.
    intRange.flatMap { a ->
        intRange.map { b -> a to b }
    } eq "[" +
            "(1, 1), (1, 2), (1, 3), " +
            "(2, 1), (2, 2), (2, 3), " +
            "(3, 1), (3, 2), (3, 3)" +
            "]"
}