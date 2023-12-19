import atomictest.eq


fun main() {
    val doubles = listOf(1.1, 2.2, 3.3, 4.4)
    doubles.sum() eq 11.0

    val strings = listOf("Twas", "Brillig", "And", "Slithy", "Toves")
    strings eq listOf("Twas", "Brillig", "And", "Slithy", "Toves")
    /*
    *  reverse 와 sorted를 호출하면 정렬한 새로운 List를 돌려준다.
    *  -> 원본 객체를 그대로 두고 새로운 객체를 만든다는 코틀린의 경향을 볼 수 있다.
    * */
    strings.sorted() eq listOf("And",
        "Brillig", "Slithy", "Toves", "Twas")
    strings.reversed() eq listOf("Toves",
        "Slithy", "And", "Brillig", "Twas")
    strings.first() eq "Twas"
    strings.takeLast(2) eq listOf()
}