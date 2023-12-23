import Test.eq
import sequences.takeIf


fun main() {
    generateSequence(6) {
        // 일반 if를 사용할 수 있지만, takeIf() 함수를 사용하는 것이 함수형 표현에 가깝다.
        (it - 1).takeIf { it > 0 }

    }.toList() eq listOf(6, 5, 4, 3, 2, 1)
}