package DataTypes

fun main() {
    val whole: Int = 11
    val fractional: Double = 1.4
    val trueOfFalse: Boolean = true
    val words: String = "A value"
    val character: Char = '2'
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