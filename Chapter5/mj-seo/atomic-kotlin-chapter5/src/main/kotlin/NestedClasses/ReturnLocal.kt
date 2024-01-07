package nestedclasses

interface Amphibian

fun createAmphibian(): Amphibian {
    class Frog : Amphibian
    return Frog()
}

fun main() {
    val amphibian = createAmphibian()

    // Frog는 지역 클래스이므로 밖에서 참조할 수 없다.
//    amphibian as Frog
}