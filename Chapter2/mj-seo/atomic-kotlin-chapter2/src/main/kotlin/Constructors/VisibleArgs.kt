package Constructors


class MutableNameAlien(var name: String)

class FixedNameAlien(val name: String)

fun main() {
    val alien1 =
        MutableNameAlien("Reverse Giraffe")
    val alien2 =
        FixedNameAlien("Krombopolis Michael")

    alien1.name = "Parasite"

    /*
    *  val로 정의한 생성자 파라미터는 변경 불가하다.
    * */
//    alien2.name = "Parasite"
}