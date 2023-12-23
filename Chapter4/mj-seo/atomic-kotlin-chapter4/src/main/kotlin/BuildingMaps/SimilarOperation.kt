import Test.eq


fun main() {
    val map = mapOf(1 to "one", -2 to "minus two")

    /*
    *  any(), all() 함수도 map에서 사용 가능하다.
    *  maxByOrNull()은 주어진 기준에 따라 가장 큰 원소를 찾는다.
    *  -> 가장 큰 원소가 없을 수도 있기 때문에 nullable 한 값을 반환한다.
    * */
    map.any { (key, _) -> key < 0 } eq true
    map.all { (key, _) -> key < 0 } eq false

    // null이 될 수 있는 타입이므로, 프로퍼티 호출시 safe-call을 사용한다.
    map.maxByOrNull { it.key }?.value eq "one"
}