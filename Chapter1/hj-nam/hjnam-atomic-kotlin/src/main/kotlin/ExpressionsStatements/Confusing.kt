package ExpressionsStatements

fun main() {
    var i = 1
    println(i++ + ++i)
    //윗 줄보다는 덜 복잡하지만 아래 두 줄의 코드도 바람직하지는 않다
    println(i++ + 10)
    println(20 * ++i)
}