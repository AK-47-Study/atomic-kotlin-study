package propertydelegation

import Test.eq
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


class Fibonacci : ReadWriteProperty<Any?, Long> {
    private var current: Long = 0

    override fun getValue(
        thisRef: Any?,
        property: KProperty<*>
    ) = current

    override fun setValue(
        // 첫 번째 타입을 Any?로 지정해 무시함으로써 더 일반적인 목적의 위임을 만들 수도 있다.
        thisRef: Any?,
        property: KProperty<*>,
        value: Long) {
        current = fibonacci(value.toInt())
    }
}

fun main() {
    var fib by Fibonacci()
    fib eq 0L
    fib = 22L
    fib eq 17711L
    fib = 90L
    fib eq 2880067194370816120L
}

fun fibonacci(n: Int): Long {
    /*
    *  꼬리 재귀를 사용하면 계산 효율이 극적으로 좋아진다.
    * */
    tailrec fun fibonacci(
        n: Int,
        current: Long,
        next: Long
    ): Long {
        if (n == 0) return current
        return fibonacci(
            n - 1, next, current + next
        )
    }

    return fibonacci(n, 0L, 1L)
}