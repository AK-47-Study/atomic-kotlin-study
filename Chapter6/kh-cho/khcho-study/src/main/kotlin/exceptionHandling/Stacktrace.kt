package Chapter6.`kh-cho`.`khcho-study`.src.main.kotlin.exceptionHandling

fun function1(): Int =
    throw Exception1(-52)

fun function2() = function1()

fun function3() = function2()

fun main() {
    function3()
}