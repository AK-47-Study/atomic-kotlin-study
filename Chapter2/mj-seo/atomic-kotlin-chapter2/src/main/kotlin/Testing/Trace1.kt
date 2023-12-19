package Testing

import atomictest.*

fun main() {
    trace("line 1")
    trace(47)
    trace eq """
        line 1
        47
        line 2
    """
}