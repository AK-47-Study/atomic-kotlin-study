package Chapter1.`kh-cho`.`khcho-study`.src.main.kotlin.`InKeyword1-13`

fun main() {
    inFloatingRange(0.999999)
    inFloatingRange(5.0)
    inFloatingRange(10.0)
    inFloatingRange(10.0000001)
}

fun inFloatingRange(n: Double) {
    val r = 1.0 .. 10.0
    println("$n in $r ? ${n in r}")
}
