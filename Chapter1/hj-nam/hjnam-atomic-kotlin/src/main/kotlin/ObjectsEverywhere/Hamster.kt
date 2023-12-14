package ObjectsEverywhere

class Hamster {
    fun speak() = "Squeak! "
    fun exercise() =
        this.speak() + // 'this' 로 한정
                speak() + // 'this' 없이 호출
                "Running on wheel"
}

fun main() {
    val hamster = Hamster()
    println(hamster.exercise())
}