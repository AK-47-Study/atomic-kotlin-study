import Test.eq


fun main() {
    val list = listOf('a', 'b', 'c', 'd')

    /*
    *  한 List에서 어떤 원소와 그 원소에 인접한 다음 원소를 묶으로면
    *  zipWithNext()를 사용하면 된다.
    * */
    list.zipWithNext() eq listOf(
        Pair('a', 'b'),
        Pair('b', 'c'),
        Pair('c', 'd')
    )

    list.zipWithNext { a, b -> "$a$b" } eq
            "[ab, bc, cd]"
}