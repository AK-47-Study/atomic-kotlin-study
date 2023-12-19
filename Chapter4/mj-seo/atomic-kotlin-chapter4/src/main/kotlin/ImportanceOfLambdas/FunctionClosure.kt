package importanceoflambdas

import atomictest.eq


var x = 100

fun useX() {
    x++
}

fun main() {
    /*
    *  일반 함수도 주변 환경의 요소를 포획할 수 있다.
    *  -> useX()는 주변 환경의 X를 포획해서 변경한다.
    * */
    useX()
    x eq 101
}