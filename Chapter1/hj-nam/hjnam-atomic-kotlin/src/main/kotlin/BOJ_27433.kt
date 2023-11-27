fun main() {
    val n: Int = readln().toInt()
    println(factorial(n))
}

fun factorial(n: Int): Long =
    if (n <= 1)
        1
    else
        n * factorial(n - 1)