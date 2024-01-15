package extensionlambdas

import Test.eq


private fun messy(): String {
    val built = StringBuilder()
    built.append("ABCs: ")
    ('a'..'x').forEach { built.append(it) }
    return built.toString()
}

// buildString은 StringBuilder 객체를 직접 만들고, append()를 호출해야 하는 불편함을 제거해준다.
private fun clean() = buildString {
    append("ABCs: ")
    ('a'..'x').forEach { append(it) }
}

private fun cleaner() =
    ('a'..'x').joinToString("", "ABCs: ")

fun main() {
    messy() eq "ABCs: abcdefghijklmnopqrstuvwx"
    messy() eq clean()
    clean() eq cleaner()
}