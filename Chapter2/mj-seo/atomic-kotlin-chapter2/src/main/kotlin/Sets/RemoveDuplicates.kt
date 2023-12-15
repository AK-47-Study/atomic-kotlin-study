import atomictest.eq


fun main() {
    val list = listOf(3, 3, 2, 1, 2)
    list.toSet() eq setOf(1, 2, 3)
    list.distinct() eq listOf(3, 2, 1)

    /*
    *  문자열에 대해서 toSet()을 호출하면 문자열에 들어 있는
    *  유일한 문자들의 집합을 얻을 수 있다.
    * */
    "abbcc".toSet() eq setOf('a', 'b', 'c')
}