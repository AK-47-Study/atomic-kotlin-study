import atomictest.eq

fun main() {
    val doubles =
        listOf(1.1, 2.2, 3.3, 4.4)
    doubles.sum() eq 11.0

    val strings = listOf("Twas", "Brillig",
        "And", "Slithy", "Toves")
    strings eq listOf("Twas", "Brillig",
        "And", "Slithy", "Toves")
    strings.sorted() eq listOf("And",           // sorted: 원본의 요소를 정렬한 새로운 List 반환
        "Brillig", "Slithy", "Toves", "Twas")   // sort: 원본 List를 직접 정렬
    strings.reversed() eq listOf("Toves",
        "Slithy", "And", "Brillig", "Twas")
    strings.first() eq "Twas"
    strings.takeLast(2) eq
            listOf("Slithy", "Toves")
}