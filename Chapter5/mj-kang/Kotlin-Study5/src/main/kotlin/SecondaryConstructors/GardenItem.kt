package secondaryConstructors

import atomictest.eq
import secondaryConstructors.Material.*


enum class Material {
    Ceramic, Metal, Plastic
}


class GardenItem(val name: String) {
    var material: Material = Plastic
    constructor(
        name: String, material: Material
    ) : this(name) {
        this.material = material
    }

    constructor(
        material: Material
    ) : this("Strange Thing", material)

    override fun toString() = "$material $name"
}

class GardenItem2(
    val name: String,
    val material: Material = Plastic
) {
    override fun toString() = "$material $name"
}

fun main() {
    GardenItem("Elf").material eq Plastic
    GardenItem("Snowman").name eq "Snowman"
    GardenItem("Gazing Ball", Metal) eq
            "Metal Gazing Ball"
    GardenItem(material = Ceramic) eq
            "Ceramic Strange Thing"

    GardenItem2("Elf").material eq Plastic
    GardenItem2("Snowman").name eq "Snowman"
    GardenItem2("Gazing Ball", Metal) eq
            "Metal Gazing Ball"
}
