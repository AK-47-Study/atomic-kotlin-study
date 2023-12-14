package Summary2

import atomictest.eq


class JetPack(
    private var fuel: Double
) {
    private var warning = false

    private fun burn() =
        if (fuel - 1 <= 0) {
            fuel = 0.0
            warning = true
        } else
            fuel -= 1

    public fun fly() = burn()

    fun check() =
        if (warning)
            "Warning"
        else
            "OK"
}

fun main() {
    val jetPack = JetPack(3.0)
    while (jetPack.check() != "Warning") {
        jetPack.check() eq "OK"
        jetPack.fly()
    }

    jetPack.check() eq "Warning"
}