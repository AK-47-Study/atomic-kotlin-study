package Chapter2.`kh-cho`.`khcho-study`.src.main.kotlin.`Maps2-12`

import atomictest.capture
import atomictest.eq

fun main() {
    val map = mapOf('a' to "attempt")
    map['b'] eq null
    capture {
        map.getValue('b')
    } eq "NoSuchElementException" +
            "Key b is missing in the map."
    map.getOrDefault('a', "???") eq "attempt"
    map.getOrDefault('b', "??") eq "??"
}