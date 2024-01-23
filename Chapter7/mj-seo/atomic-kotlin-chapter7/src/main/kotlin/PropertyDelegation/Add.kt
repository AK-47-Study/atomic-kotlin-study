package propertydelegation

import Test.eq
import kotlin.reflect.KProperty


class Add(val a: Int, val b: Int) {
    val sum by Sum()
}

class Sum()

// 위임자 객체의 멤버에 대한 접근이 충분할 경우 getValue()와 setValue()를 확장 함수로 정의할 수 있다.
operator fun Sum.getValue(
    thisRef: Add,
    property: KProperty<*>
) = thisRef.a + thisRef.b

fun main() {
    val addition = Add(144, 12)
    addition.sum eq 156
}