package DataTypes
fun main() {
    /*
    *  타입을 섞어서 사용한 경우에도 코틀린은
    *  타입 추론을 사용해 전체 문장이나 식의 의미를 결정한다.
    * */
    val n = 1 + 1.2
    println(n)
}