package Packages

/*
*  as 키워드를 사용하면 임포트하면서 이름을 변경할 수 있다.
* */
import kotlin.math.PI as circleRatio
import kotlin.math.cos as cosine


fun main() {
    println(circleRatio)
    println(cosine(circleRatio))
    println(cosine(2 * circleRatio))
}