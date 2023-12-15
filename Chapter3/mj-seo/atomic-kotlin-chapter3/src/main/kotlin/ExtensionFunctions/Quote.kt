package other

import atomictest.eq
import extensionfunctions.doubleQuote
import extensionfunctions.singleQuote


fun main() {
    /*
    *  확장 함수를 정의되지 않은 다른 패키지에서
    *  사용하려면 import가 필요하다.
    * */
    "Single".singleQuote() eq "'Single'"
    "Double".doubleQuote() eq "\"Double\""
}