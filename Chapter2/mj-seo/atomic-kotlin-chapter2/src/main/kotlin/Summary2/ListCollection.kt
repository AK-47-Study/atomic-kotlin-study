import atomictest.eq


fun main() {
    val list = listOf(19.2, 88.3, 22.1)
    list[1] eq 88.3 // 인덱싱

    /*
    *  sorted() reversed()를 호출해도 list 내부는 바뀌지 않는다.
    *  -> 원본 객체를 바꾸지 않는 접근 방식은 코틀린 라이브러리에서 일관성 있게 볼 수 있다.
    * */
    list.reversed() eq listOf(22.1, 88.3, 19.2)
    list.sorted() eq listOf(19.2, 22.1, 88.3)
    list.sum() eq 129.6
}