package destructuring.compute

import atomictest.eq
import destructuring.compute


fun main() {
    /*
    *  val (a, b, c) = 여러_값이_들어있는 값
    *  -> 구조 분해 선언을 이용하면 여러 값이 들어 있는 값을 여러 컴포넌트로 분해해서
    *     각 컴포넌트를 순서대로 대입해준다(구조 분해 선언)
    * */
    val (value, description) = compute(7)
    value eq 14
    description eq "High"
}