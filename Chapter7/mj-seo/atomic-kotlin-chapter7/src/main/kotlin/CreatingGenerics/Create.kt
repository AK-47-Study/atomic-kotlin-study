package creatinggenerics

import Test.eq


open class Create<T>(private var contents: T) {
    fun put(item: T) { contents = item }
    fun get(): T = contents
}

fun main() {
    val cc = Create(Car())
    val car: Car = cc.get()
    car eq "Car"
}