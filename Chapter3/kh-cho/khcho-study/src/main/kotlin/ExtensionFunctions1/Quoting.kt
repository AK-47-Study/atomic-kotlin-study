package Chapter3.`kh-cho`.`khcho-study`.src.main.kotlin.ExtensionFunctions1

import atomictest.eq

fun String.singleQuote() = "'$this'"
fun String.doubleQuote() = "\"$this\""

fun main() {
    "Hi".singleQuote() eq "'Hi'"
    "Hi".doubleQuote() eq "\"Hi\""
}