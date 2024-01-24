package propertydelegation

import Test.eq


class Driver(
    map: MutableMap<String, Any?>
) {
    // command + 왼쪽 마우스로 by를 클릭하면 MutableMap의 프로퍼티 위임 상세 구현을 볼 수 있다.
    var name: String by map
    var age: Int by map
    var id: String by map
    var available: Boolean by map
    var coord: Pair<Double, Double> by map
}

fun main() {
    val info = mutableMapOf<String, Any?>(
        // Map의 Key와 프로퍼티의 이름이 같아야 한다.
        "name" to "Bruno Fiat",
        "age" to 22,
        "id" to "X97C111",
        "available" to false,
        "coord" to Pair(111.93, 1231.12)
    )

    val driver = Driver(info)
    driver.available eq false
    driver.available = true

    info eq "{name=Bruno Fiat, age=22, id=X97C111, available=true, coord=(111.93, 1231.12)}"
}