package Chapter2.`kh-cho`.`khcho-study`.src.main.kotlin.CreatingClasses

class Hamster {
    fun speak() = "Squeak"
    fun exercise() = this.speak()+
            speak() +
            "Running on wheel"

}

fun main() {
    val hamster = Hamster()
    println(hamster.exercise())
}