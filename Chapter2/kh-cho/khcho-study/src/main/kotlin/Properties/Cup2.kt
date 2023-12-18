package Chapter2.`kh-cho`.`khcho-study`.src.main.kotlin.Properties

class Cup2 {
    var percentFull = 0
    val max = 100
    fun add(increase: Int): Int{
        percentFull += increase
        if (percentFull > max)
            percentFull = max
        return percentFull
    }
}

fun main() {
    val cup = Cup2()
    cup.add(50)
    println(cup.percentFull)
    cup.add(70)
    println(cup.percentFull)
}