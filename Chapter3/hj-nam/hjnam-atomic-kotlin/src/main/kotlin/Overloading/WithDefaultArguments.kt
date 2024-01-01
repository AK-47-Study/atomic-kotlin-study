package withdefaultarguments
import atomictest.eq

// 권장하는 방식
fun f(n: Int = 0) = n + 373

fun main() {
    f() eq 373
}