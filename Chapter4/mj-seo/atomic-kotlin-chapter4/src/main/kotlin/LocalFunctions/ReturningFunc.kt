package localfunctions

import Test.eq


// 익명 함수 반환
fun first(): (Int) -> Int {
    val func = fun(i: Int) = i + 1
    func(1) eq 2
    return func
}

// 람다 반환
fun second(): (String) -> String {
    val func2 = { s: String -> "$s!" }
    func2("abc") eq "abc!"
    return func2
}

// 지역 함수에 대한 참조 반환
fun third(): () -> String {
    fun greet() = "Hi!"
    return ::greet
}

// 식 본문 사용으로 간결한 함수 반환(익명 함수)
fun fourth() = fun() = "Hi!"

// 람다를 식 본문 함수에 사용해 반환
fun fifth() = { "Hi!" }

fun main() {
    val funRef1: (Int) -> Int = first()
    val funRef2: (String) -> String = second()
    val funRef3: () -> String = third()
    val funRef4: () -> String = fourth()
    val funRef5: () -> String = fifth()

    funRef1(42) eq 43
    funRef2("xyz") eq "xyz!"
    funRef3() eq "Hi!"
    funRef4() eq "Hi!"
    funRef5() eq "Hi!"

    /*
    *  first() 함수를 호출하면 함수가 반환되므로, 뒤에 인자 목록(42)를 추가해 반환된 함수를 호출할 수 있다.
    * */
    first()(42) eq 43
    second()("xyz") eq "xyz!"
    third()() eq "Hi!"
    fourth()() eq "Hi!"
    fifth()() eq "Hi!"
}