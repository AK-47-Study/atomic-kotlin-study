package operatoroverloading

import Test.eq


data class R(val r: IntRange) {
    override fun toString() = "R($r)"
}

// 범위를 생성하는 ..연산자를 오버로드한다.
operator fun E.rangeTo(e: E) = R(v..e.v)

// 값이 범위 안에 들어가는지 여부를 알려주는 in 연산을 오버로드 한다.
operator fun R.contains(e: E) = e.v in r

fun main() {
    val a = E(2)
    val b = E(3)
    val r = a..b

    (a in r) eq true
    (a !in r) eq false
    r eq R(2..3)
}