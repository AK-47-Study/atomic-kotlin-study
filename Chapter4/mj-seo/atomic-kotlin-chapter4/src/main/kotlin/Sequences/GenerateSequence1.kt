import Test.eq


fun main() {
    /*
    *  generateSequence()는 자연수로 이루어진 무한 시퀀스를 만든다.
    *  -> generateSequence()의 첫 번째 인자는 시퀀스의 첫 원소이고,
    *     두 번째 인자는 이전 원소로부터 다음 원소를 만들어내는 방법을 정의한 람다다.
    * */
    val naturalNumbers =
        generateSequence(1) { it + 1}

    naturalNumbers.take(3).toList() eq
            listOf(1, 2, 3)

    naturalNumbers.take(10).sum() eq 55
}