package Chapter4.`kh-cho`.`khcho-study`.src.main.kotlin.Lambdas1

import atomictest.trace

fun main() {
    run { -> trace("A Lambda") }
    run { trace("Without args") }
    trace eq """
        A lambda
        Without args
    """
}