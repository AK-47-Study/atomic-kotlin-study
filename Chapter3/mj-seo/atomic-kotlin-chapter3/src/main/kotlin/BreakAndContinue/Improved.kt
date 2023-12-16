import atomictest.eq


/*
*  break나 continue를 사용하는 대신 이터레이션 조건을 명시적으로 작성할 수 있는 경우가 있다.
*  -> 루프 전체나 루프 본문을 별도의 함수로 추출하면 break나 continue를 return으로 대체할 수 있다.
*     함수형 프로그래밍을 적용하면 break와 continue 없이 더 깔끔한 코드를 작성할 수 있다.
* */
fun main() {
    val strings = mutableListOf<String>()

    for (c in 'a'..'c') {
        for (i in 1..4) {
            val value = "$c$i"
            if (value < "c3") {
                strings.add(value)
            }
        }
    }

    strings eq listOf("a1", "a2", "a3", "a4",
        "b1", "b2", "b3", "b4", "c1", "c2")
}