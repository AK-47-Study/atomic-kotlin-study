package higherorderfunctions

import Test.trace


fun repeat(
    times: Int,
    // (Int) -> Unit 타입의 함수를 파라미터로 받는다.
    action: (Int) -> Unit
) {
    for (index in 0 until times) {
        action(index)
    }
}

fun main() {
    repeat(3) { trace("#$it") }
    trace eq "#0 #1 #2"
}