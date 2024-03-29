package Chapter5.`kh-cho`.`khcho-study`.src.main.kotlin.SealedClasses

import atomictest.eq

sealed class Top
class Middle1 : Top()
class Middle2 : Top()
open class Middle3 : Top()
class Bottom3 :Middle3()

fun main() {
    Top::class.sealedSubclasses
        .map { it.simpleName } eq
            "[Middle1, Middle2, Middle3]"
}