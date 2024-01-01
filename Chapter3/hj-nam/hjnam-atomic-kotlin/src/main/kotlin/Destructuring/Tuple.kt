package destructuring
import atomictest.eq

data class Tuple(
    val i: Int,
    val d: Double,
    val s: String,
    val b: Boolean,
    val l: List<Int>
)

fun main() {
    val tuple = Tuple(
        1, 3.14, "Mouse", false, listOf()
    )
    val (i, d, s, b, l) = tuple
    i eq 1
    d eq 3.14
    s eq "Mouse"
    b eq false
    l eq listOf()

    val (_, _, animal) = tuple // 필요하지 않은 경우, 이름 대신 밑줄(_) 사용하거나 생략
    animal eq "Mouse"
}