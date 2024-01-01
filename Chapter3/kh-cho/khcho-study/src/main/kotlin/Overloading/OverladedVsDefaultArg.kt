package Chapter3.`kh-cho`.`khcho-study`.src.main.kotlin.Overloading

import atomictest.trace

fun foo(n: Int = 99) = trace("foo-1-$n")
fun foo() {
    trace("foo-2")
    foo(14)
}
    fun main() {
        foo()
        trace eq """
            foo-2
            foo-1-14
        """
}