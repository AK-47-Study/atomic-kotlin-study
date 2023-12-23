import Test.eq
import sequences.*


fun main() {
    val r = listOf(1, 2, 3, 4)
        /*
        *  Sequence 연산에는 중간 연산과 최종 연산 두 가지가 있다.
        *  -> TransformingSequence는 연산을 저장만 할 뿐, 수행하지는 않는다.
        * */
        .asSequence()
        .filter(Int::isEven)
        .map(Int::square)

    r.toString().substringBefore("@") eq
            "kotlin.sequences.TransformingSequence"
}