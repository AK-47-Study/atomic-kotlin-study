import Test.eq


fun main() {
    val list = listOf(1, 10, 100, 1000)
    var accumulator = 0
    val operation =
        { sum: Int, i: Int -> sum + i }

    /*
    *  fold()는 순수 함수형 언어에서 값을 누적시키는 유일한 방법이지만,
    *  코틀린에서는 여전히 일반 for 루프를 사용하는 경우가 많다.
    * */
    for (i in list) {
        accumulator = operation(accumulator, i)
    }

    accumulator eq 1111
}