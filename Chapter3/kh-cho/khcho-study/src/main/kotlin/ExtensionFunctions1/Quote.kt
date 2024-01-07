package Chapter3.`kh-cho`.`khcho-study`.src.main.kotlin.ExtensionFunctions1

import atomictest.eq

fun main() {
    "Single".singleQuote() eq "'Single'"
    "Double".doubleQuote() eq "\"Single\""
}