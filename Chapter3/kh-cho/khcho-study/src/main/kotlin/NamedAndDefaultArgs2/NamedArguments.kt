package Chapter3.`kh-cho`.`khcho-study`.src.main.kotlin.NamedAndDefaultArgs2

import atomictest.eq

fun color(red: Int, green: Int, blue: Int) =
    "($red, $green, $blue)"

fun main() {
    color(1, 2, 3) eq "(1, 2, 3)" // [1]
    color(
        red = 76, // [2]
        green = 89,
        blue = 0
    )eq "(76, 89, 0)"
    color(52, 34, blue = 0) eq // [3]
            "(52, 34, 0)"
}