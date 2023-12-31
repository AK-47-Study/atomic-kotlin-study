package Chapter2.`kh-cho`.`khcho-study`.src.main.kotlin.PropertyAccessors

import atomictest.eq

class Counter {
    var value: Int = 0
        private set
    fun inc() = value ++
}

fun main() {
    val counter = Counter()
    repeat(10){
        counter.inc()
    }
    counter.value eq 10
}