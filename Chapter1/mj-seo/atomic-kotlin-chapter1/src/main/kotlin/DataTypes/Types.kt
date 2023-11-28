package DataTypes
fun main() {
    val whole: Int = 11
    val fractional: Double = 1.4
    val trueOfFalse: Boolean = true
    val words: String = "A value"
    val character: Char = '2'
    /*
    *  Kotlin 에서는 쌍 따옴표 세 개로 멀티라인 문자열을 표현할 수 있다.
    * */
    val lines: String = """
        Triple quotes let
        you have many lines
        in your string
    """.trimIndent()

    println(whole)
    println(fractional)
    println(trueOfFalse)
    println(words)
    println(character)
    println(lines)
}