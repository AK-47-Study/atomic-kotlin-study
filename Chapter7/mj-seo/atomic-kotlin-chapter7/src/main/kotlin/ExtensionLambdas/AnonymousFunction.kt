package extensionlambdas

import Test.eq


fun exec(
    arg1: Int, arg2: Int,
    f: Int.(Int) -> Boolean
) = arg1.f(arg2)

fun main() {
    // 확장 람다 대신 익명 함수를 사용하는 것도 가능하다.
    exec(10, 2, fun Int.(d:Int): Boolean {
        return this % 2 == 0
    }) eq true
}