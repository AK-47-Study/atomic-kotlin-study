package extensionlambdas

import Test.eq


// 일반 람다를 인자로 받는다.
fun String.transform1(
    n: Int, lambda: (String, Int) -> String
) = lambda(this, n)

// 확장 람다를 인자로 받는다.
fun String.transform2(
    n: Int, lambda: String.(Int) -> String
) = lambda(this, n)

val duplicate: String.(Int) -> String = {
    repeat(it)
}

val alternate: String.(Int) -> String = {
    toCharArray()
        .filterIndexed { i, _ -> i % it == 0}
        .joinToString("")
}

fun main() {
    "hello".transform1(5, duplicate)
        .transform2(3, alternate) eq "hleolhleo"

    "hello".transform2(5, duplicate)
        .transform1(3, alternate) eq "hleolhleo"
}