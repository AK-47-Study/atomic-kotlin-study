package summary2

import atomictest.*


class GetterAndSetter {

    /*
    * field
    * -> field를 포함하지 않고, 결과를 얻기 위해 다른 멤버 함수를 호출하거나
    *    다른 프로퍼티에 의존하는 세터와 게터가 정의된 프로퍼티를 정의할 수도 있다.
    * */
    var i: Int = 0
        get() {
            trace("get()")
            return field
        }
        set(value) {
            trace("set($value)")
            field = value
        }
}

fun main() {
    val gs = GetterAndSetter()
    gs.i = 2
    trace(gs.i)
    trace eq """
        set(2)
        get()
        2
    """.trimIndent()
}