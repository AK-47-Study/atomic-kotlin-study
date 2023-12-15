import atomictest.*


fun main() {
    trace("Hello,")
    trace(47)
    trace("World!")

    /*
    *  trace 함수는 함수 호출 구문을 사용해 결과를 누적시킨다.
    *  -> println을 trace로 효과적으로 대치할 수 있다.
    * */
    trace eq """
        Hello,
        47
        World!
    """.trimIndent()
}