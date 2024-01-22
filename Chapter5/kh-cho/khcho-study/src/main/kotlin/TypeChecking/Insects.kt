package Chapter5.`kh-cho`.`khcho-study`.src.main.kotlin.TypeChecking

import atomictest.eq

interface Insect {
    fun walk() = "$name: walk"
    fun fly() = "$name: fly"
}

class HouseFly : Insect

class Flea : Insect {
    override fun fly() =
        throw Exception("Flea cannot fly")
    fun crawl() = "Flea: crawl"
}

fun Insect.basic() =
    walk() + " " +
            if (this is Flea)
                crawl()
else
    fly()

interface SwimmingInsect: Insect{
    fun swim() = "$name: swim"
}

interface WaterWalker: Insect{
    fun walkWater() =
        "$name: walk on water"
}

class WaterBeetle : SwimmingInsect
class WaterStrider : WaterWalker
class WhirlingigBeetle :
        SwimmingInsect, WaterWalker

fun Insect.water() =
    when(this) {
        is SwimmingInsect -> swim()
        is WaterWalker -> walkWater()
        else -> "$name: drown"
    }

fun main() {
    val insects = listOf(
        HouseFly(), Flea(), WaterStrider(),
        WaterBeetle(), WhirlingigBeetle()
    )
    insects.map { it.basic() } eq
            "[HoseFly: walk HouseFly : fly," +
            "Flea : walk Flea : crawl," +
            "WaterSrider : walk Water Strider : fly"
}