import atomictest.eq


fun main() {
    val list = listOf(9, 11, 23, 32)
    // 함수의 여러 파라미터를 받고, 람다가 마지막 파라미터인 경우에는 인자목록을 감싼 괄호 다음에 위치시킬 수 있다.
    list.joinToString(" ") { "[$it]" } eq
            "[9] [11] [23] [32]"
}