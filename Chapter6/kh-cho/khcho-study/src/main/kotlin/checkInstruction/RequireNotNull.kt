package Chapter6.`kh-cho`.`khcho-study`.src.main.kotlin.checkInstruction

import Chapter6.`kh-cho`.`khcho-study`.src.main.kotlin.capture
import Chapter6.`kh-cho`.`khcho-study`.src.main.kotlin.eq

fun notNull(n: Int?) : Int{
    requireNotNull(n) {
        "notNull() argument cannot be null"
    }
    return n * 9
}

fun main() {
    val n: Int? = null
    capture {
        notNull(n)
    } eq "IllegalArgumentException: " +
            "notNull() argument cannot be null"
    capture {
        requireNotNull(n)
    } eq "IllegalArgumentException: " +
            "Required value was null."
    notNull(11) eq 99
}