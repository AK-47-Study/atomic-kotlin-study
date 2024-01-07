package objects

import Test.eq


open class Paint(private val color: String) {
    open fun apply() = "Applying $color"
}

// object는 다른 일반 클래스나 인터페이스를 상속할 수 있다.
object Acrylic: Paint("Blue") {
    override fun apply() =
        "Acrylic, ${super.apply()}"
}

interface PaintPreparation {
    fun prepare(): String
}

object Prepare: PaintPreparation {
    override fun prepare() = "Scrape"
}

fun main() {
    Prepare.prepare() eq "Scrape"
    Paint("Green").apply() eq "Applying Green"
    Acrylic.apply() eq "Acrylic, Applying Blue"
}