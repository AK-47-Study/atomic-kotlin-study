package ObjectsEverywhere

import java.util.*


fun main() {
    val s = "AbcD"
    println(s.reversed())

    // toLowercase() 메서드는 현재 deprecated 되었다.
    println(s.lowercase(Locale.getDefault()))
}