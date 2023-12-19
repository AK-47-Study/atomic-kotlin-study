import atomictest.eq


fun main() {
    val constants = mapOf(
        "Pi" to 3.141,
        "e" to 2.718,
        "phi" to 1.618
    )

    constants eq
            "{Pi=3.141, e=2.718, phi=1.618}"

    // 키에 해당하는 값을 찾는다.
    constants["e"] eq 2.718
    constants.keys eq setOf("Pi", "e", "phi")
    constants.values eq "[3.141, 2.718, 1.618]"

    var s = ""
    // Key-Value Iteration
    for (entry in constants) {
        s += "${entry.key}=${entry.value}, "
    }

    s eq "Pi=3.141, e=2.718, phi=1.618,"
    s = ""

    // Iteration을 하면서 Key - Value 분리
    for ((key, value) in constants) {
        s += "$key=$value, "
    }

    s eq "Pi=3.141, e=2.718, phi=1.618,"
}