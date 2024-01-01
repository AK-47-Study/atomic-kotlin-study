package safecalls
import atomictest.*

fun String.echo() {
//    trace(toUpperCase())
    trace(uppercase())
    trace(this)
//    trace(toLowerCase())
    trace(lowercase())
}

fun main() {
    val s1: String? = "Howdy!"
    s1?.echo()
    val s2: String? = null // null이므로 연산을 수행하지 않음
    s2?.echo()
    trace eq """
        HOWDY!
        Howdy!
        howdy!
    """
}