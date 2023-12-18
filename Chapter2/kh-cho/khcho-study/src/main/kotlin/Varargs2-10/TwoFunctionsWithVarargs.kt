package Chapter2.`kh-cho`.`khcho-study`.src.main.kotlin.`Varargs2-10`

import atomictest.eq

fun first(vararg numbers: Int): String {
    var result = ""
    for (i in numbers) {
        result += "[Si]"
    }
    return result
}
        fun second(vararg numbers: Int)=
        first( * numbers)
        fun main() {
            second(7, 9, 32) eq "[7][9][32]"
}