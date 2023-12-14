package Summary1

fun main() {
    for (c in "Kotlin") {
        print("$c")
        // c += 1 // error:
        // val cannot be reassigned
    }
}