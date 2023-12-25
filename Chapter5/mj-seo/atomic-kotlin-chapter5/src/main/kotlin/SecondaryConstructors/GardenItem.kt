package secondaryConstructors

import Test.eq
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

    // 부생성자 본문을 적지 않아도 되지만, this() 호출은 반드시 포함해야 한다.
    constructor(
        material: Material
    ) : this("Strange Thing", material)

    override fun toString() = "$material $name"
}

/*
 *  GradenItem 클래스를 디폴트 인자를 써서 부생성자를 주생성자 하나로 만들면,
 *  훨씬 단순하게 만들 수 있다.
 */
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