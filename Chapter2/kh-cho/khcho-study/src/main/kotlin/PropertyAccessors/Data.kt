package Chapter2.`kh-cho`.`khcho-study`.src.main.kotlin.PropertyAccessors

import atomictest.eq

class Data (var i:Int)

fun main() {
    val data = Data(10)
    data.i eq 10
    data.i = 20
}