package Chapter7.`kh-cho`.`khcho-study`.src.main.kotlin.extensionLambdas

import atomictest.eq

val va: (String, Int) -> String = {str, n ->
    str.repeat(n) + str.repeat(n)
}

val  vb: String.(Int) -> String = {
    this.repeat(it) + repeat(it)
}

fun main() {
    va("Vanbo", 2) eq "VanboVanboVanboVanbo"
    "Vanbo".vb(2) eq "VanboVanboVnabop"
    vb("Vanbo", 2) eq "VanboVanboVnabop"
}