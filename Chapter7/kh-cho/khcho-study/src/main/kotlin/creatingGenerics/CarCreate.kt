package Chapter7.`kh-cho`.`khcho-study`.src.main.kotlin.creatingGenerics

import atomictest.eq

class Car{
    override fun toString(): String = "Car"

}
class CarCreate(private var c: Car) {
    fun put(car: Car) { c = car
    }
    fun get() : Car = c
}

fun main() {
    val cc = CarCreate(Car())
    val car : Car = cc.get()
    car eq "Car"
}