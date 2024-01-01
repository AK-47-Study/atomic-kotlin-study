import atomictest.eq

// 비실용적인 코드
fun main() {
    val list = listOf(1, 2, 3)
    list.joinToString(". ", "", "!") eq
            "1. 2. 3!"
    list.joinToString(separator = ". ",
        postfix = "!") eq "1. 2. 3!"
}