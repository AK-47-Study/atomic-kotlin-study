package sequences

import atomictest.eq
import sequences.takeIf


fun main() {
    generateSequence(6) {
        (it - 1).takeIf { it > 0 }

    }.toList() eq listOf(6, 5, 4, 3, 2, 1)
}