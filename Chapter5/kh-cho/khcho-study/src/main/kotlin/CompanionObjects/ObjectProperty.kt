package Chapter5.`kh-cho`.`khcho-study`.src.main.kotlin.CompanionObjects

import atomictest.eq

class WithObjectProperty {
    companion object {
        private var n: Int = 0 // 단 하나만 생김
    }
    fun increment() = ++n
}
fun main() {
    val a = WithObjectProperty()
    val b = WithObjectProperty()
    a.increment() eq 1
    b.increment() eq 2
    a.increment() eq 3
}