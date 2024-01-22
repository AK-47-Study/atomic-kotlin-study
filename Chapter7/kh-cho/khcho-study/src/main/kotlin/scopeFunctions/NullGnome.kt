package Chapter7.`kh-cho`.`khcho-study`.src.main.kotlin.scopeFunctions

import atomictest.trace

fun whichGnome(gnome: Gnome?){
    trace(gnome?.name)
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
    """
}