package propertydelegation

import Test.eq
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty


class Readable2(val i: Int) {
    val value: String by BasicRead2()

    // SAM 변환
    val value2: String by
            ReadOnlyProperty {_, _ -> "getValue: $i"}
}

// 인퍼테이스를 필수적으로 구현해야 하는 것은 아니지만, ReadOnlyProperty 인터페이스를 구현해서 위임 역할을 수행할 수도 있다.
class BasicRead2 : ReadOnlyProperty<Readable2, String> {
    override operator fun getValue(
        thisRef: Readable2,
        property: KProperty<*>
    ) = "getValue: ${thisRef.i}"
}

fun main() {
    val x = Readable2(11)
    val y = Readable2(17)

    x.value eq "getValue: 11"
    x.value2 eq "getValue: 11"

    y.value eq "getValue: 17"
    y.value2 eq "getValue: 17"

}

