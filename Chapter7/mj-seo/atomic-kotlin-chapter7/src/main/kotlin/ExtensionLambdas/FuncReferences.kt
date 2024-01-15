package extensionlambdas

import Test.eq


fun Int.d1(f: (Int) -> Int) = f(this) * 10

fun Int.d2(f: Int.() -> Int) = f() * 10

fun f1(n: Int) = n + 3

fun Int.f2() = this + 3

fun main() {
    // ::을 활용하면 확장 람다가 필요한 곳에 함수 참조를 넘길 수 있다.
    74.d1(::f1) eq 770
    74.d2(::f1) eq 770
    74.d1(Int::f2) eq 770
    74.d2(Int::f2) eq 770
}