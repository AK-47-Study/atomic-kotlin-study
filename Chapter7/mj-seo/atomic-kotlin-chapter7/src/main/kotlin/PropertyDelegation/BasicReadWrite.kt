package propertydelegation

import Test.eq
import kotlin.reflect.KProperty


class ReadWriteable(var i: Int) {
    var msg = ""
    var value: String by BasicReadWrite()
}

class BasicReadWrite {
    operator fun getValue(
        rw: ReadWriteable,
        property: KProperty<*>
    ) = "getValue: ${rw.i}"

    operator fun setValue(
        rw: ReadWriteable,
        property: KProperty<*>,
        // 세 번째 파라미터 값의 타입은 위임 객체가 적용된 프로퍼티의 타입과 일치해야 한다.
        s: String
    ) {
        rw.i = s.toIntOrNull() ?: 0
        rw.msg = "setValue to ${rw.i}"
    }
}

fun main() {
    val x = ReadWriteable(11)
    x.value eq "getValue: 11"
    x.value = "99"
    x.msg  eq "setValue to 99"
    x.value eq "getValue: 99"
}