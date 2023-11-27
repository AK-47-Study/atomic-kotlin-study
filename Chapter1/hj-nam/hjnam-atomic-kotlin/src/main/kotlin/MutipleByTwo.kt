fun multipleByTwo(x: Int): Int {
    println("Inside multipleByTwo")
    return x * 2
}

fun main() {
    val r = multipleByTwo(5)
    println(r)
}

// multipleByTwo main 아래에 있어도 정상 실행