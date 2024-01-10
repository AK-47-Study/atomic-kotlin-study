package exceptionhandling

import Test.eq


fun testCatchOrder(which: Int) =
    try {
        toss(which)
        // 더 구체적인 예외 타입이 바로 아래 Catch 블럭에 있지만, Exception2를 처리하는 핸들러가 Exception3를 처리한다.
    } catch (e: Exception2) {
        "Handler for Exception2 got ${e.message}"
    } catch (e: Exception3) {
        "Handler for Exception3 got ${e.message}"
    }

fun main() {
    testCatchOrder(2) eq
            "Handler for Exception2 got Exception 2"

    testCatchOrder(3) eq
            "Handler for Exception2 got Exception 3"
}