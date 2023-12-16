import atomictest.eq


fun main() {
    val s1: String = "abc"
    val s2: String? = s1

    s1.length eq 3

    // 컴파일 되지 않는다 -> null이 가능한 타입이면 역참조를 하지 못하게 한다.
//    s2.length
}