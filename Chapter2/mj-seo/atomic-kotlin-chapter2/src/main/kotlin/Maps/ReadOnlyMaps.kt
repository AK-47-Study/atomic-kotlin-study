import atomictest.eq


fun main() {
    val m = mapOf(5 to "five", 6 to "six")
    m[5] eq "five"

//    m[5] = "5ive" -> 실패
//    m += 4 to "four" -> 실패
    m + (4 to "four") // m을 바꾸지 않는다.
    m eq mapOf(5 to "five", 6 to "six")

    /*
    *  + 연산은 기존 맵의 원소와 더해진 원소를 포함하는 새 Map을 만든다.
    *  -> 원래의 Map에는 영향을 미치지 않고, 읽기 전용 Map에 원소를 추가하는 유일한 방법이다.
    * */
    val m2 = m + (4 to "four")
    m2 eq mapOf(
        5 to "five", 6 to "six", 4 to "four"
    )
}
