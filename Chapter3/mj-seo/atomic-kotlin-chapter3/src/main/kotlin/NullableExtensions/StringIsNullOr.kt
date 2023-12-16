import atomictest.eq


fun main() {
    val s1: String? = null
    /*
    *  String? 타입의 확장함수이기 때문에 safe-call을 사용하지 않아도
    *  호출이 가능하고, null이라고 하더라도 NPE가 발생하지 않는다.
    * */
    s1.isNullOrEmpty() eq true
    s1.isNullOrBlank() eq true

    val s2 = ""
    s2.isNullOrEmpty() eq true
    s2.isNullOrBlank() eq true

    val s3: String = "\t\n"
    // 수신 String이 null이거나 빈 문자열인지 검사
    s3.isNullOrEmpty() eq false
    // 수신 String이 null이거나, 온전히 공백 문자(\t, \n)로만 구성되어 있는지 검사
    s3.isNullOrBlank() eq true
}