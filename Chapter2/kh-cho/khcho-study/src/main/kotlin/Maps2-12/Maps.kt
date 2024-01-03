package Chapter2.`kh-cho`.`khcho-study`.src.main.kotlin.`Maps2-12`

import atomictest.eq

fun main() {
    val constant = mapOf(
        "Pi" to 3.141,
        "e" to 2.718,
        "phi" to 1.618
    )
    constant eq
            "{Pi = 3.141, e = 2.718, phi - 1.618}"

    // 키에 해당하는 값을 찾는다
    constant["e"] eq 2.718
    constant.keys eq setOf("Pi", "e" ,"phi")
    constant.values eq "[3.141, 2.718, 1.618]"

    var s = ""
    // 키-값 쌍을 이터레이션한다
    for (entry in constant){
        s += "${entry.key}=${entry.value}, "
    }
    s eq "Pi=3.141, e=2.718, phi=1.618,"

    s = ""
    // 이터레이션을 하면서 키와 값을 분리한다
    for ((key, value) in constant)
        s += "$key=$value, "
    s eq "Pi=3.141, e=2.718, phi=1.618,"
}