package ExpressionsStatements

fun main() {
    println(unitFun())
    val u1: Unit = println(42)
    println(u1)
    val u2 = println(0)
    println(u2)
}

fun unitFun() = Unit