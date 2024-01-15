package scopefunctions


class Gnome(val name: String) {
    fun who() = "Gnome: $name"
}

fun whatGnome(gnome: Gnome?) {
    gnome?.let { it.who() }
    gnome.let { it?.who() }

    gnome?.run { who() }
    gnome.run { this?.who() }

    gnome?.apply { who() }
    gnome.apply { this?.who() }

    gnome?.also { it.who() }
    gnome.also { it?.who() }

    // gnome이 null인지 검사할 방법이 없다.
    with(gnome) { this?.who() }
}