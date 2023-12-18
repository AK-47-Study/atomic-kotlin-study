package Chapter2.`kh-cho`.`khcho-study`.src.main.kotlin.`Varargs2-10`

fun main(args: Array<String>) {
    if (args.size < 3) return
    val first = args[0]
    val second = args[1].toInt()
    val third = args[2].toFloat()
    println("$first $second $third")
}