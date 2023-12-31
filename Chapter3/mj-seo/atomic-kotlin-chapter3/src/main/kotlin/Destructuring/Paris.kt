package destructuring

import atomictest.eq


/*
*  Pair를 사용하면 두 값을 반환할 수 있다.
* */
fun compute(input: Int): Pair<Int, String> =
    if (input > 5)
        Pair(input * 2, "High")
    else
        Pair(input * 2, "Low")

fun main() {
    compute(7) eq Pair(14, "High")
    compute(4) eq Pair(8, "Low")

    val result = compute(5)
    result.first eq 10
    result.second eq "Low"
}