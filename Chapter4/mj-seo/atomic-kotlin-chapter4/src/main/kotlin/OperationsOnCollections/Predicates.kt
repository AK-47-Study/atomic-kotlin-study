import Test.eq


fun main() {
    val list = listOf(-3, -1, 5, 7, 10)

    /*
    *  filter()와 count()는 모든 원소에 대해 조건을 적용한다.
    * */
    list.filter { it > 0 } eq listOf(5, 7, 10)
    list.count { it > 0 } eq 3

    /*
    *  any()와 find()는 결과를 찾으면
    *  이터레이션을 중단한다.
    * */
    list.find { it > 0 } eq 5
    list.firstOrNull { it > 0 } eq 5
    list.lastOrNull { it < 0 } eq -1

    list.any { it > 0 } eq true
    list.any { it != 0 } eq true

    // all()은 모든 원소가 조건과 일치하는지 검사한다.
    list.all { it > 0 } eq false
    list.all { it != 0 } eq true

    // none()은 조건과 일치하는 원소가 하나도 없는지 검사한다.
    list.none { it > 0 } eq false
    list.none { it == 0 } eq true
}