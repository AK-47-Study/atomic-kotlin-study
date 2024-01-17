package creatinggenerics

import Test.eq


class Car {
    override fun toString() = "Car"
}

class CarCreate(private var c: Car) {
    fun put(car: Car) { c = car }
    fun get(): Car = c
}

fun main() {
    val cc = CarCreate(Car())
    val car: Car = cc.get()
    car eq "Car"
}