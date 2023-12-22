import Test.eq


fun main() {
    val list = listOf(1, 2, 3, 4)
    /*
    *  filter()는 보존하고 싶은 원소를 선택하는 Predicate를 인자로 받는다.
    *  이 함수를 람다로 지정할 수 있다.
    * */
    val even = list.filter { it % 2 == 0 }
    val greaterThan2 = list.filter { it > 2 }

    even eq listOf(2, 4)
    greaterThan2 eq  listOf(3, 4)
}