package objectshare2

import Test.eq
import objectshare1.f
import objectsharing.Shared


fun g() {
    // 모든 패키지에서 Shared가 같다는 점을 알 수 있다.
    Shared.i += 7
}

fun main() {
    f()
    g()
    Shared.i eq 12
}