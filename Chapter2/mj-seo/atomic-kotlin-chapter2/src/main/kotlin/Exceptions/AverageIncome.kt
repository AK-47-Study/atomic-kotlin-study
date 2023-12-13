package firstversion

import atomictest.capture
import atomictest.eq


fun averageIncome(income: Int, months: Int) =
    income / months

fun main() {
    averageIncome(3300, 3) eq 1100
    /*
    *  capture 함수는 코틀린에서 지원하는 기능이아니다.
    * */
    capture {
        averageIncome(5000, 0)
    } eq "ArithmeticException: / by zero"
}