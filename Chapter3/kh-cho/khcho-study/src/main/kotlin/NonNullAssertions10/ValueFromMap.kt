package Chapter3.`kh-cho`.`khcho-study`.src.main.kotlin.NonNullAssertions10

import atomictest.capture
import atomictest.eq

fun main() {
    val map = mapOf(1 to "one")
    map[1]!!.toUpperCase() eq "ONE"
    map.getValue(1).toUpperCase() eq "ONE"
    capture {
        map[2]!!.toUpperCase()
    } eq "NullPointerException"
    capture {
        map.getValue(2).toUpperCase()
    } eq "NoSuchElementException： " +
            "Key 2 is missing in the map."
}