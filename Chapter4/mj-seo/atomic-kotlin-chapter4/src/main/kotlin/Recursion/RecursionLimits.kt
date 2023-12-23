package recursion

import Test.eq


fun sum(n : Long): Long {
    if (n == 0L) return 0
    return n + sum(n - 1)
}

fun main() {
    sum(2) eq 3
    sum(1000) eq 500500
    // StackOverflowError를 막기 위해서는 재귀 대신 Iteration을 택해야 한다.
//    sum(100_000) eq 5000050000
    (1..100_000L).sum() eq 5000050000
}