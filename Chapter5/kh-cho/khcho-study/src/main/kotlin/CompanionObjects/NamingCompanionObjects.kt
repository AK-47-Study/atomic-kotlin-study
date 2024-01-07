package Chapter5.`kh-cho`.`khcho-study`.src.main.kotlin.CompanionObjects

import atomictest.eq

class WithNamed {
    companion object Named {
        fun s() = "from Named"
    }
}
        class WithDefault {
            companion object {
                fun s() = "from Default"
            }
        }
fun main() {
    WithNamed.s() eq "from Named"
    WithNamed.Named.s() eq "from Named"
    WithDefault.s() eq "from Default"
    WithDefault.Companion.s() eq "from Default"
}