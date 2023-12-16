package nullableextensions

import atomictest.eq


/*
*  isNullOrEmpty()와 같은 상황이 단순하고 함수 이름에서 수신 객체가
*  null일 수 있음을 암시하는 경우에는 null이 될 수 있는 타입의 확장함수가 유용하다.
*  -> 그렇지 않은 경우에는 null이 될 수 있는 타입의 확장 함수는 null 가능성을 감춘다.
* */
fun String?.isNullOrEmpty(): Boolean =
    this == null || isEmpty()


fun main() {
    "".isNullOrEmpty() eq true
}