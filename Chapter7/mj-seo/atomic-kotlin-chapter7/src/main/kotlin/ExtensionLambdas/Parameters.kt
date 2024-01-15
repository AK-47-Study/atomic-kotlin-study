package extensionlambdas

import Test.eq


val zero: Int.() -> Boolean = {
    this == 0
}

// 가리키는 대상이 명확하지 않다면 it를 사용하지 않고, 명시적인 파라미터 이름을 붙여주는 것이 낫다.
val one: Int.(Int) -> Boolean = {
    this % it == 0
}

// 확장 람다도 여러 파라미터를 받을 수 있다.
val two: Int.(Int, Int) -> Boolean = {
    arg1, arg2 -> this % (arg1 + arg2) == 0
}

val three: Int.(Int, Int, Int) -> Boolean = {
    arg1, arg2, arg3 ->
    this % (arg1 + arg2 + arg3) == 0
}

fun main() {
    0.zero() eq true
    10.one(10) eq true
    20.two(10, 10) eq true
    30.three(10, 10, 10) eq true
}