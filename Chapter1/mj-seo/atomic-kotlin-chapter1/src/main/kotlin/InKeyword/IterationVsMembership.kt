package InKeyword

fun main() {
    val values = 1..3
    // for 루프 제어식에 있는 in만 이터레이션을 뜻한다.
    for (v in values) {
        println("iteration $v")
    }

    val v = 2
    // for 루프 제어식 이외에서 쓰이는 in은 모두 원소인지 여부를 검사하는 in이다.
    if (v in values)
        println("$v is a member of $values")
}