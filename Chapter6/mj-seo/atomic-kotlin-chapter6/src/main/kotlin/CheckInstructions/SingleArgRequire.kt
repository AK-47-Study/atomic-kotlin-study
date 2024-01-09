package checkinstructions

import Test.capture
import Test.eq


fun singleArgRequire(arg: Int): Int {
    // 디폴트 메시지를 보여주는 파라미터가 한 개인 require 함수도 있다.
    require(arg > 5)
    return arg
}

fun main() {
    capture {
        singleArgRequire(5)
    } eq "IllegalArgumentException: " +
            "Failed requirement."

    singleArgRequire(6) eq 6
}

