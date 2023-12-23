import Test.eq


fun main() {
    val map = mapOf(1 to "one", 2 to "two")

    /*
    *  getOrElse()는 키에 해당하는 값이 없을때
    *  디폴트 값을 계산하는 방법이 담긴 람다를 인자로 받는다.
    * */
    map.getOrElse(0) { "zero" } eq "zero"

    val mutableMap = map.toMutableMap()
    /*
    *  getOrPut()은 키가 있으면 값을 반환하고, 그렇지 않은 경우
    *  값을 계산하고 그 값을 저장한 후에 저장한 값을 반환한다.
    *  -> Map을 변경하는 연산이므로 mutableMap에만 사용가능하다.
    * */
    mutableMap.getOrPut(0) { "zero" } eq "zero"

    mutableMap eq "{1=one, 2=two, 0=zero}"
}