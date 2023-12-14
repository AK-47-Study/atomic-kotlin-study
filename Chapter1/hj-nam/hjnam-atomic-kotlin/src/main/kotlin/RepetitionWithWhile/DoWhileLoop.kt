package RepetitionWithWhile

fun condition1(i: Int) = i < 100

fun main() {
    var i = 0
    do {
        print(".")
        i += 10
    } while (condition1(i))
}