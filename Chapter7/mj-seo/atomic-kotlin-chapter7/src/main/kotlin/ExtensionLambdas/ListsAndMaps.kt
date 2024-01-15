package ExtensionLambdas

import Test.eq

/*
*  확장 람다 안에서 List와 Map은 가변이지만 buildList와 buildMap의 결과는
*  읽기 전용 컬렉션을 반환한다.
*/
val characters: List<String> = buildList {
    add("Chars:")
    ('a'..'d').forEach { add("$it") }
}

val charMap: Map<Char, Int> = buildMap {
    ('A'..'F').forEachIndexed { n, ch ->
        put(ch, n)
    }
}

fun main() {
    characters eq "[Chars:, a, b, c, d]"
    charMap eq "{A=0, B=1, C=2, D=3, E=4, F=5}"
}
