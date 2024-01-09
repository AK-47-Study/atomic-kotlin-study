package checkinstructions

import Test.capture
import Test.eq


fun notNull(n: Int?): Int {
    requireNotNull(n) {
        "notNull() argument cannot be null"
    }

    // requireNotNull() 호출이 null-check를 하기 때문에 더 디상의 null-check가 필요없다.
    return n * 9
}

fun main() {
    val n: Int? = null
    capture {
        notNull(n)
    } eq "IllegalArgumentException: " +
            "notNull() argument cannot be null"

    capture {
        requireNotNull(n)
    } eq "IllegalArgumentException: "  +
            "Required value was null."

    notNull(11) eq 99
}

