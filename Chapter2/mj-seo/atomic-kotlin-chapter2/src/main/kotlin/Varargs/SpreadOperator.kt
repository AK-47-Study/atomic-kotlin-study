import atomictest.eq


fun main() {
    val array = intArrayOf(4, 5)
    sum(1, 2, 3, *array, 6) eq 21

    // 다음은 컴파일되지 않는다.
    // sum(1, 2, 3, array, 6)

    val list = listOf(9, 10, 11)

    /*
    *  Array는 항상 가변 객체이다.
    *  -> Array를 인자 목록으로 변환하고 싶으면 스프레드 연산자(*)를 사용한다.
    * */
    sum(*list.toIntArray()) eq 30
}