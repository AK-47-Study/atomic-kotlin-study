package propertydelegation

import Test.eq
import kotlin.reflect.KProperty


class Readable(val i : Int) {
    val value: String by BasicRead()
}

class BasicRead {
    operator fun getValue(
        r: Readable,
        // KProperty 타입은 위임 프로퍼티에 대한 리플렉션 정보를 제공한다.
        property: KProperty<*>
    ) = "getValue: ${r.i}"
}

fun main() {
    val x = Readable(11)
    val y = Readable(17)

    x.value eq "getValue: 11"
    y.value eq "getValue: 17"
}
