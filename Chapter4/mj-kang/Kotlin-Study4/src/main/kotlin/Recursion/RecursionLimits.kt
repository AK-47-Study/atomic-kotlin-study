package recursion

import atomictest.eq


fun sum(n : Long): Long {
    if (n == 0L) return 0
    return n + sum(n - 1)
}

fun main() {
    sum(2) eq 3
    sum(1000) eq 500500

    (1..100_000L).sum() eq 5000050000
}
