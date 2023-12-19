package Packages


fun main() {
    /*
    *  코드 안에서 임포트한 이름의 패키지 경로를 전부 다 쓸수도 있다.
    *  -> 이 방식은 가독성이 떨어지지만, 각 요소의 출처를 명확하게 알 수 있다!
    * */
    println(kotlin.math.PI)
    println(kotlin.math.cos(kotlin.math.PI))
    println(kotlin.math.cos(2 * kotlin.math.PI))
}