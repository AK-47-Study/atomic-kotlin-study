package Constructors


fun main() {
    val krombopulousMichael =
        AlienSpecies("Gromflomite", 2, 2, 2)

    /*
    *  println() 함수는 문자열 대신 객체를 전달받은 경우,
    *  객체의 toString()을 호출한 결과를 출력한다.
    * */
    println(krombopulousMichael)
}