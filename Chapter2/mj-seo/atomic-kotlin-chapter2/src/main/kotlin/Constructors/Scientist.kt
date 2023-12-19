package Constructors


class Scientist(val name: String) {

    // 한 줄에 식으로 표현하는 것도 가능하다.
//    override fun toString() = "Scientist('$name')"

    override fun toString(): String {
        return "Scientist('$name')"
    }
}

fun main() {
    val zeep = Scientist("Zeep Xanflorp")
    println(zeep)
}