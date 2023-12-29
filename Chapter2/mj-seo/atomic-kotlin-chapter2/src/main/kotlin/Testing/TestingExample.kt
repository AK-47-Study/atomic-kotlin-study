package Testing

import atomictest.*

fun main() {
    val v1 = 11
    val v2 = "Ontology"

    v1 eq 11
    v2 eq "Ontology"

    v2 neq "Epistimology"
    v2 eq "Epistimology"
}