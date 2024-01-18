package operatoroverloading

import Test.eq


operator fun String.invoke(
    f: (s: String) -> String
) = f(this)

fun main() {

    "mumbling" { it.uppercase() } eq
            "MUMBLING"

    // 함수 참조가 있는 경우 참조를 넘길 수도 있다.
    "mumbling".invoke(String::uppercase) eq
            "MUMBLING"
}