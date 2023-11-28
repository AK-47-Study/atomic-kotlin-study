package NumberTypes

fun main() {
    val i = Int.MAX_VALUE
    println(0L + i + i)

    // 피연산자 중에 하나가 Long 타입이기만 하면 전체 식의 결과 타입도 Long이 된다.
    println(1_000_000 * 1_000_000L)
}