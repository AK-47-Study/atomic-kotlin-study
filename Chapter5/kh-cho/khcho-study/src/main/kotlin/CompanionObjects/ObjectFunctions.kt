package Chapter5.`kh-cho`.`khcho-study`.src.main.kotlin.CompanionObjects

import atomictest.eq

class CompanionObjectFunction {
    companion object {
        private var n: Int = 0
        fun increment() = ++n
    }
}

fun main() {
    CompanionObjectFunction.increment() eq 1
    CompanionObjectFunction.increment() eq 2
}