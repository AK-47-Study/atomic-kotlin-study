package Summary1

fun main() {
    println(cube(3))
    println(bang("pop"))
}

fun cube(x: Int): Int {
    return x * x * x
}

fun bang(s: String) = s + "!"