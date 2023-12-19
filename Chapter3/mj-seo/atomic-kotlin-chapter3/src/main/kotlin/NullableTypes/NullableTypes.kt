import atomictest.eq


fun main() {
    val s1 = "abc"

    // 컴파일 오류 -> null이 될 수 없는 타입에는 null 할당이 불가능하다.
//    val s2: String = null

    // null 될 수 있는 경우
    val s3: String? = null

    /*
    *  String과 String?은 서로 다른 타입이다.
    *  -> null이 되지 못하는 타입은 결코 null이 되지 않게 해준다.
    * */
    val s4: String? = s1

    val s6 = s4

    s1 eq "abc"
    s3 eq null
    s4 eq "abc"
    s6 eq "abc"
}