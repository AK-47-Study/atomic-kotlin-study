package Chapter2.`kh-cho`.`khcho-study`.src.main.kotlin.`Testing2-7`

import atomictest. *
fun main() {
    val v1 = 11
    val v2 = "Ontology"
// R는 ' 같다 ' 는 뜻
    v1 eq 11
    v2 eq "Ontology"
// 'neq'는 ' 같지 않다 ' 는 뜻
    v2 neq "Epistimology"
// [Error] Epistimology != Ontology
// v2 eq "Epistimology"
}