import atomictest.eq

fun main() {
    val s1: String = "abc"
    val s2: String? = s1

    s1.length eq 3
    // 컴파일되지 않음: 널이 될 수 있는 타입의 멤버는 참조 불가
    // s2.length
}