package propertydelegation

import Test.eq
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


class ReadWriteable2(var i: Int) {
    var msg = ""
    var value: String by BasicReadWrite2()
}

class BasicReadWrite2 : ReadWriteProperty<ReadWriteable2, String> {
    override fun getValue(
        thisRef: ReadWriteable2,
        property: KProperty<*>
    ) = "getValue: ${thisRef.i}"

    override fun setValue(
        thisRef: ReadWriteable2,
        property: KProperty<*>,
        value: String) {
        thisRef.i = value.toIntOrNull() ?: 0
        thisRef.msg = "setValue to ${thisRef.i}"
    }
}

fun main() {
    val x = ReadWriteable2(11)
    x.value eq "getValue: 11"
    x.value = "99"
    x.msg eq "setValue to 99"
    x.value eq "getValue: 99"
}