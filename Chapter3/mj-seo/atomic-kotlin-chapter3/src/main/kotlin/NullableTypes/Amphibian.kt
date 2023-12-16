package nullabletypes

class Amphibian

enum class Species {
    Frog, Toad, Salamander, Caecilian
}

fun main() {
    /*
    *  null이 될 수 없는 타입을 정의하면, null이 될 수 있는 타입도
    *  자동으로 사용할 수 있게 된다.
    * */
    val a1: Amphibian = Amphibian()
    val a2: Amphibian? = null
    val at1: Species = Species.Toad
    val at2: Species? = null
}