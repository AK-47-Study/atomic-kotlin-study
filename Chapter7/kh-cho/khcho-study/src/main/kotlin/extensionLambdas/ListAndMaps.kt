package Chapter7.`kh-cho`.`khcho-study`.src.main.kotlin.extensionLambdas

import atomictest.eq

val character: List<String> = buildList {
    add("Chars:")
    ('a'..'b').forEach{add("$it")}
}

val charmap: Map<Char, Int> = buildMap {
    ('A'..'F').forEachIndexed { n, ch ->
        put(ch,n)
    }
}

fun main() {
    character eq "[Chars: ,a, b, c, d]"
    charmap eq  "{A=0, B=1, C=2, D=3, E=4, F=5}"
}