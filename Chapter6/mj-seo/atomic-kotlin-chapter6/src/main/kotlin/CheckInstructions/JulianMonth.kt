package checkinstructions

import Test.capture
import Test.eq


data class Month(val monthNumber: Int) {
    init {
        // require() 함수는 보통 함수 인자를 검증하기 위해 사용된다.
        require(monthNumber in 1..12) {
            "Month out of range: $monthNumber"
        }
    }
}

fun main() {
    Month(1) eq "Month(monthNumber=1)"

    capture { Month(13) } eq
            "IllegalArgumentException: Month out of range: 13"
}