package delegationtools

import Test.capture
import Test.eq
import kotlin.properties.Delegates


class NeverNull {
    // Delegates.notNull() 함수는 읽기 전에 꼭 초기화해야 하는 프로퍼티를 정의한다.
    var nn: Int by Delegates.notNull()
}

fun main() {
    val non = NeverNull()

    capture {
        non.nn
    } eq "IllegalStateException: Property nn should be initialized before get."

    non.nn = 11
    non.nn eq 11
}