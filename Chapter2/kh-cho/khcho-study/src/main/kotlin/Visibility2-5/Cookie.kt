package Chapter2.`kh-cho`.`khcho-study`.src.main.kotlin.`Visibility2-5`

class Cookie (
    private var isReady: Boolean
){
    private fun crumble() =
        println("crumble")

    private fun bite() =
        println("bite")

    fun eat() {
        isReady = true
        crumble()
        bite()
    }
}

fun main() {
    val x = Cookie(false)
//    x.bite()
    x.eat()
}