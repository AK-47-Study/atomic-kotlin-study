import Test.trace
import sequences.*


fun main() {
    val list = listOf(1, 2, 3, 4)

    trace(list.asSequence()
        .filter(Int::isEven)
        .map(Int::square)
        /*
        *  toList()는 최종 연산으로, Sequence를 List로 변환하며,
        *  시퀀스를 처리하는 과정에서 저장된 모든 연산을 실행한다.
        * */
        .toList())

    trace eq """
        1.isEven()
        2.isEven()
        2.square()
        3.isEven()
        4.isEven()
        4.square()
        [4, 16]
    """.trimIndent()
}