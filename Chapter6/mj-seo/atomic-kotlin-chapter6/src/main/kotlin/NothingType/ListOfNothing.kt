import Test.eq


fun main() {
    /*
    *  nullableString과 nullableInt에도 Nothing? 타입을 넣을 수 있다.
    */
    val none: Nothing? = null


    var nullableString: String? = null
    nullableString = "abc"
    nullableString = none
    nullableString eq null

    val nullableInt: Int? = none
    nullableInt eq null

    // null이 될 수 있는 타입이 원소인 List를 가리킬때는 원소의 타입을 명시하지 않으면 Nothing?으로 추론된다.
    val listNone: List<Nothing?> = listOf(null)
    val ints: List<Int?> = listOf(null)
    ints eq listNone
}