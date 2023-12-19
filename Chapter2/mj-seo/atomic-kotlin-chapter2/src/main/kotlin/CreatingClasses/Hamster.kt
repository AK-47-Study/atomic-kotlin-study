package CreatingClasses

class Hamster {
    fun speak() = "Squeak! "

    /*
    *  this를 반드시 명시적으로 사용해야 하는 언어가 아니라면
    *  불필요한 this는 코드에 작성하지 않는 것이 좋다.
    *  클래스 밖에서는 hamster.exercise() 또는 hamster.speak()처럼
    *   객체를 지정해 멤버 함수를 호출해야 한다.
    * */
    fun exercise() =
        this.speak() +
                speak() +
                "Running on wheel"
}

fun main() {
    val hamster = Hamster()
    println(hamster.exercise())
}