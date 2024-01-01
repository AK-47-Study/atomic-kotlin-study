import atomictest.eq

fun main() {
    val s1 = "abc"

    // 컴파일 오류: null can not be a value of a non-null type String
    // val s2: String = null

    // 널이 될 수 있는 정의들
    val s3: String? = null
    val s4: String? = s1

    // 컴파일 오류: Type mismatch: inferred type is String? but String was expected
    // val s5: String = s4
    val s6 = s4
    // s4가 널이 될 수 있는 타입이므로
    // s6도 타입 추론을 통해 널이 될 수 있는 타입이 됨

    s1 eq "abc"
    s3 eq null
    s4 eq "abc"
    s6 eq "abc"
}