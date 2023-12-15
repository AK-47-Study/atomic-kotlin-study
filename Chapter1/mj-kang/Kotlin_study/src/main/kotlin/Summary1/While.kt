package Summary1

fun main() {
    var i = 0
    while (testCondition(i)) {
        print(".")
        i += 10
    }
}

fun testCondition(i: Int) = i < 100