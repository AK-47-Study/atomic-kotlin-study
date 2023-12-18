package Chapter2.`kh-cho`.`khcho-study`.src.main.kotlin.Properties

class House{
    var sofa : String = ""
}

fun main() {
    val house = House()
    house.sofa = "Simple sleeper sofa : $89.00"
    println(house.sofa)
    house.sofa = "New leater sofa : $381.189.00"
    println(house.sofa)
}