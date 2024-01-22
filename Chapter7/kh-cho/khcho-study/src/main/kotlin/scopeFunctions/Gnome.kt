package Chapter7.`kh-cho`.`khcho-study`.src.main.kotlin.scopeFunctions

class Gnome(
    val name: String
) {
    fun who() = "Gnome: $name"
}

fun whatGnome(gnome: Gnome?) {
    gnome?.let { it.who() } // [1 ]
    gnome.let { it?.who() }

    gnome?.run { who() } // [2]
    gnome.run { this?.who() }

    gnome?.apply { who() } // [3]
    gnome.apply { this?.who() }

    gnome?.also { it.who() } // [4]
    gnome.also { it?.who() }

    // gnomeOl 널인지 검사할 방법이 없다

    with(gnome) { this?.who() }
}