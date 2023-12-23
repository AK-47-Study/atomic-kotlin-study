import Test.capture
import Test.eq


fun main() {
    val items = mutableListOf(
        "first", "second", "third", "XXX", "4th"
    )

    /*
    *  Sequence의 다음 원소를 반환하는 람다만 받는 generateSequence()
    *  오버로딩 버전도 있다.
    * */
    val seq = generateSequence {
        /*
        *  removeAt(0) 함수는 List의 첫 번째 원소를 제거하고 그 원소를 반환한다.
        *  -> takeIf() 함수는 수신 객체가 조건을 만족하면 수신 객체를 반환하고, 아니라면 null을 반환한다.
        * */
        items.removeAt(0).takeIf { it != "XXX" }
    }

    seq.toList() eq "[first, second, third]"

    /*
    *  Sequence는 한 번만 Iteration 할 수 있다.
    *  -> Iteration을 다시 시도하면 예외가 발생한다.
    *     Sequence를 여러 번 처리해야 한다면, 우선 Sequence를 Collection 타입 중 하나로 변환해야 한다.
    * */
    capture {
        seq.toList()
    } eq "IllegalStateException: This " +
            "sequence can be consumed only once."
}