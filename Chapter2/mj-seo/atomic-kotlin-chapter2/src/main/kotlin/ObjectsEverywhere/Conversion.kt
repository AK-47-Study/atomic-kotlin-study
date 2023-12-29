package ObjectsEverywhere


fun main() {

    /*
    *  문자를 정수로 변환
    * */
    val s = "123"
    println(s.toInt())

    /*
    *  정수를 문자로 변환
    * */
    val i = 123
    println(i.toString())

    /*
    *  Kotlin 에서는 수 타입 사이의 변환을 명시적으로 해야 한다.
    * */
    val l = 123.242
    println(l.toInt())
}