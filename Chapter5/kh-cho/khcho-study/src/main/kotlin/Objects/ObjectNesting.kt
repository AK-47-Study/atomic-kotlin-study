package Chapter5.`kh-cho`.`khcho-study`.src.main.kotlin.Objects

import atomictest.eq

object Outer {
    object Nested {
        val a = "Outer.Nested.a"
    }
}
class HasObject {
    object Nested {
        val a = "HasObject.Nested.a"
    }
}
fun main() {
    Outer.Nested.a eq "Outer.Nested.a"
    HasObject.Nested.a eq "HasObject.Nested.a"
}