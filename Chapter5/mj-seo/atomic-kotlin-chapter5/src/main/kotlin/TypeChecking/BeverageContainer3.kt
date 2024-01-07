package typechecking3

import Test.eq
import typechecking.name


interface BeverageContainer {
    fun open(): String
    fun pour() = "$name: Pour"
    fun recycle(): String
}

abstract class Can : BeverageContainer {
    override fun open() = "Pop Top"
}

class SteelCan : Can() {
    override fun recycle() = "Recycle Steel"
}

class AluminumCan : Can() {
    override fun recycle() = "Recycle Aluminum"
}

abstract class Bottle: BeverageContainer {
    override fun open() = "Remove Cap"
}

class GlassBottle : Bottle() {
    override fun recycle() = "Recycle Glass"
}

abstract class PlasticBottle : Bottle()

class PETBottle : Bottle() {
    override fun recycle() = "Recycle PET"
}

class HDPEBottle : Bottle() {
    override fun recycle() = "Recycle HDPE"
}

fun main() {
    /*
    *  Can과 Bottle을 abstract class로 정의함으로서, 컴파일러는 모든 하위 클래스가 recycle()을
    *  오버라이드 하도록 강제한다.
    * */
    val refrigerator = listOf(
        SteelCan(), AluminumCan(),
        GlassBottle(),
        PETBottle(), HDPEBottle()
    )

    refrigerator.map { it.open() } eq
            "[Pop Top, Pop Top, Remove Cap, " +
            "Remove Cap, Remove Cap]"

    refrigerator.map { it.recycle() } eq
            "[Recycle Steel, Recycle Aluminum, " +
            "Recycle Glass, " +
            "Recycle PET, Recycle HDPE]"
}

