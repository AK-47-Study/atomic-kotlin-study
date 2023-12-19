package Exceptions

import atomictest.eq

fun main() {
    /*
    *  String.toIntOrNull() 함수를 제공해서,
    *  정수로 반환할 수 없는 문자열의 경우 null을 돌려준다.
    * */
    "1$".toIntOrNull() eq null
}