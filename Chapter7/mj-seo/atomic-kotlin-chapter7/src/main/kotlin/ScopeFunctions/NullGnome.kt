package scopefunctions

import Test.trace


fun whichGnome(gnome: Gnome?) {
    trace(gnome?.name)

    // let(), run(), also(), apply() 함수에 safe-call을 사용하면 수신 객체가 null인 경우 전체 영역이 무시된다.
    gnome?.let { trace(it.who()) }
    gnome?.run { trace(who()) }
    gnome?.apply { trace(who()) }
    gnome?.also { trace(it.who()) }
}

fun main() {
    whichGnome(Gnome("Bob"))
    whichGnome(null)

    trace eq """
        Bob
        Gnome: Bob
        Gnome: Bob
        Gnome: Bob
        Gnome: Bob
        null
    """.trimIndent()
}