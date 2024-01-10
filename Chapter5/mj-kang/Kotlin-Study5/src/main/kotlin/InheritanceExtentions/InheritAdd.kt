package inheritanceextensions

import atomictest.eq

class HVAC: Heater() {
    fun cool(temperature: Int) =
        "cooling to $temperature"
}

fun warmAndCool(havc: HVAC) {
    havc.heat(70) eq "heating to 70"
    havc.cool(60) eq "cooling to 60"
}

fun main() {
    val heater = Heater()
    val hvac = HVAC()

    warm(heater)
    warm(hvac)
    warmAndCool(hvac)
}

