import Test.eq


fun main() {
    val even = mapOf(2 to "two", 4 to "four")
    even.map {
        "${it.key}=${it.value}"
    } eq listOf("2=two", "4=four")

    even.map { (key, value) ->
        "$key=$value"
    } eq listOf("2=two", "4=four")

    /*
    *  mapKeys()나 mapValues()는 모든 키나 값이 변환된 새 맵을 반환한다.
    * */
    even.mapKeys { (num, _) -> -num }
        .mapValues { (_, str) -> "minus $str" } eq
            mapOf(-2 to "minus two", -4 to "minus four")

    /*
    *  map()은 Pair의 List를 반환하기 때문에, toMap()을 명시적으로 호출해야
    *  Map을 반환 받을 수 있다.
    * */
    even.map { (key, value) ->
        -key to "minus $value"
    }.toMap() eq mapOf(-2 to "minus two",
        -4 to "minus four")
}