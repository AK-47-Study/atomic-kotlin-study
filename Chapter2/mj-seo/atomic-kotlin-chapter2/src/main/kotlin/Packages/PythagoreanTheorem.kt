package pythagorean

import kotlin.math.sqrt

/*
*  Kotlin은 파일 이름이 항상 클래스 이름과 같지 않아도 된다.
*  소스 코드 파일 이름으로 아무 이름이나 붙여도 된다.
* */
class RightTriangle(
    val a: Double,
    val b: Double
) {
    fun hypotenuse() = sqrt(a * a + b * b)
    fun area() = a * b / 2
}