package ExpressionsStatements


fun main() {
    var i = 1

    // 4
    println(i++ + ++i)

    // 13
    println(i++ + 10)

    // 120
    println(20 * ++i)
}