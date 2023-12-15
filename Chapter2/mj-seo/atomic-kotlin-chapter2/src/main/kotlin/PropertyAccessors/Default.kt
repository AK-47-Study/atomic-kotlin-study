import atomictest.trace

class Default {
    var i: Int = 0
        /*
        *  field라는 이름은 getter와 setter에서만 접근 가능한 이름이다.
        * */
        get() {
            trace("get()")
            return field
        }
        set(value) {
            trace("set($value)")
            field = value
        }
}

fun main() {
    val d = Default()
    d.i = 2
    trace(d.i)

    trace eq """
        set(2)
        get()
        2
    """.trimIndent()
}