package summary2.varargs

import atomictest.trace
import summary2.varargs

fun main() {
    val array = intArrayOf(4, 5)
    varargs("x", 1, 2, 3, *array, 6)
    val list = listOf(9, 10, 11)

    /*
    *  여러 값으로 이루어진 시퀀스로 취급하려면 스프레드 연산자인 '*'를 사용해야한다.
    *  -> 스프레드 연산자는 배열에만 적용할 수 있으므로, List의 경우 먼저 배열로 변환하는
    *     함수를 호출해야한다.
    * */
    varargs(
        "y", 7, 8, *list.toIntArray())

    trace eq "1 2 3 4 5 6 x 7 8 9 10 11 y"
}