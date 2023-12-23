import Test.eq


fun main() {

    val anyPredicate: (Int) -> Boolean = { it < 10 }

    /*
    *  List에 대한 연산은 즉시 계산된다.
    *  -> 함수를 호출하자마자 모든 원소에 대해 바로 계산이 이뤄진다.
     */
    val list = listOf(1, 2, 3, 4)
    list.filter { it % 2 == 0 }
        .map { it * it }
        .any(anyPredicate) eq true

    // 위의 과정은 아래의 코드와 같다.
    val mid1 = list.filter { it % 2 == 0 }
    mid1 eq listOf(2, 4)

    val mid2 = mid1.map { it * it }
    mid2 eq listOf(4, 16)
    mid2.any(anyPredicate) eq true
}