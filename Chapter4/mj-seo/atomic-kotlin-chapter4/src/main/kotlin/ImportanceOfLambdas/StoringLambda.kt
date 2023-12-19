import atomictest.eq


fun main() {
    val list = listOf(1, 2, 3, 4)
    /*
    *  람다를 val이나 var에 담을 수 있다.
    *  -> 코틀린 타입 추론기가 파라미터의 타입을 결정할 수 있는 문맥이 없으므로, 타입을 명시해 주어야 한다.
    * */
    val isEven = { e: Int -> e % 2 == 0 }

    list.filter(isEven) eq listOf(2, 4)
    // any는 주어진 조건을 만족하는 원소가 하나라도 있는지 검사한다.
    list.any(isEven) eq true
}