package classdelegation

import atomictest.eq

class DelegationControls(
    private val controls: SpaceShipControls =
        SpaceShipControls()
): Controls by controls {
    override fun turboBoost(): String =
        "${controls.turboBoost()}... boooooost!"
}

fun main() {
    val controls = DelegationControls()
    controls.forward(100) eq "forward 100"
    controls.turboBoost() eq
            "turbo boost... boooooost!"
}

