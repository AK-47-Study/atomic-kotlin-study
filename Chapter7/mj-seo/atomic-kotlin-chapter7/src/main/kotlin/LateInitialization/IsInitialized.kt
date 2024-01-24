package lateinitialization

import Test.trace


class WithLate {
    lateinit var x: String
    // isInitialized를 이용하면 초기화 여부를 확인할 수 있다.
    fun status() = "${::x.isInitialized}"
    fun localLateInit() {
        lateinit var z: String

        /*
        *  지역 lateinit var를 정의할 수 있지만, isInitialized 호출이 불가능하다.
        *  -> 지역 var 또는 val에 대한 참조를 허용하지 않기 때문이다.
        */
//        trace(::z.isInitialized)
    }
}

lateinit var y: String

fun main() {
    trace("${::y.isInitialized}")
    y = "Ready"
    trace("${::y.isInitialized}")
    val withLate = WithLate()
    trace(withLate.status())
    withLate.x = "Set"
    trace(withLate.status())

    trace eq "false true false true"
}