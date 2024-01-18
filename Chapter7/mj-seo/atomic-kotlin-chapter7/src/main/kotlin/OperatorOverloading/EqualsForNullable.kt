package operatoroverloading

import Test.eq


fun equalsWithIf(a: E?, b: E?) =
    if (a === null)
        b === null
    else
        a == b

fun equalsWithElvis(a: E?, b: E?) =
    // equalsWithIf()와 같은 동작을 하지만, 엘비스 연산자와 안전한 호출을 사용하기 때문에 코드가 더 간결하다.
    a?.equals(b) ?: (b === null)

fun main() {
    val x: E? = null
    val y = E(0)
    val z: E? = null

    (x == y) eq false
    (x == z) eq true

    equalsWithIf(x, y) eq false
    equalsWithIf(x, z) eq true

    equalsWithElvis(x, y) eq false
    equalsWithElvis(x, z) eq true
}