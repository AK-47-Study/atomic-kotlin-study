import Test.eq


fun main() {
    val set = setOf("a", "ab", "ac")

    // maxByOrNull()은 컬렉션이 비어 있으면 null을 반환하므로 결과 타입이 null이 될 수 있는 타입이다.
    set.maxByOrNull { it.length }?.length eq 2

    // filter() & map()을 Set에 적용하면 List로 결과를 받는다.
    set.filter {
        it.contains('b')
    } eq listOf("ab")

    set.map { it.length } eq listOf(1, 2, 2)
}

