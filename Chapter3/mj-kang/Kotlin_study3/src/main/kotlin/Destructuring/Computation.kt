package Destructuring

import atomictest.eq


data class Computation(
    val data: Int,
    val info: String,
)

fun evaluate(input: Int) =
    if (input > 5)
        Computation(input * 2, "High")
    else
        Computation(input * 2, "Low")

fun main() {
    /*
    *  data 클래스의 인스턴스를 구조 분해할 경우,
    *  data 클래스 생성자에 각 프로퍼티가 나열된 순서대로 값이 대입된다.
    * */
    val (value, description) = evaluate(7)
    value eq 14
    description eq "High"
}