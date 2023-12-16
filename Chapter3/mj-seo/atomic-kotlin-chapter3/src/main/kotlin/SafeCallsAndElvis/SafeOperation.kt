package safecalls

import atomictest.trace


fun String.echo() {
    trace(uppercase())
    trace(this)
    trace(lowercase())
}

fun main() {
    val s1: String? = "Howdy!"
    /*
    *  safe call은 일반 호출에 사용하는 점(.)을 물음표와 점(?.)으로 바꾼 것이다.
    *  -> safe call을 사용하면 수신 객체가 null이 아닐때만 연산을 수행한다.
    * */
    s1?.echo()

    val s2: String? = null
    s2?.echo()

    trace eq """
        HOWDY!
        Howdy!
        howdy!
    """.trimIndent()
}