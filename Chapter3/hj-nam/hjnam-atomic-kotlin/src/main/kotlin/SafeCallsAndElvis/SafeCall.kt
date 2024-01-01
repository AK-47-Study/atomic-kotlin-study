package safecalls
import atomictest.eq

fun checkLength(s: String?, expected: Int?) {
    val length1 =
        if (s != null) s.length else null // 아래의 s?.length 와 똑같은 의미
    val length2 = s?.length
    length1 eq expected
    length2 eq expected
}

fun main() {
    checkLength("abc", 3)
    checkLength(null, null)
}