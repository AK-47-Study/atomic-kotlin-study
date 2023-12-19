//package NamedAndDefaultArgs
package color1.color

import atomictest.eq
import color1.color

fun main() {
    color(blue = 0, red = 99, green = 52) eq
            "(99, 52, 0)"

    color(red = 255, 255, 0) eq
            "(255, 255, 0)"
}