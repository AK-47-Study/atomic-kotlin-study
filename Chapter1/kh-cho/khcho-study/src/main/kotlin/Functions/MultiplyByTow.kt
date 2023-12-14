package Functions

fun multiplyByTwo(x: Int): Int{
    println("inside")
    return x + 2
}

fun main() {
    val r = multiplyByTwo(5)
    println(r)
}