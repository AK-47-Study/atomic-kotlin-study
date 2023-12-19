import atomictest.trace


fun main() {
    val list = listOf('a', 'b', 'c')

    /*
    *  withIndex()는 표준 라이브러리가 제공하는 함수이다.
    *  -> 컬렉션의 값을 IndexedValue 라는 타입의 객체에 담아서 반환한다.
    *     구조 분해 선언은 지역 var나 val에만 적용할 수 있다 -> 클래스 프로퍼티를 정의할 때는 사용불가
    * */
    for ((index, value) in list.withIndex()) {
        trace("$index:$value")
    }

    trace eq "0:a 1:b 2:c"
}