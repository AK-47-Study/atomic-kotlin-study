package operationsoncollections

import Test.eq


data class Product(
    val description: String,
    val price: Double,
)

fun main() {
    val products = listOf(
        Product("bread", 2.0),
        Product("wine", 5.0)
    )


    // sumByDouble() 함수는 현재 deprecated 되었다.
    products.sumOf { it.price } eq 7.0

    // sortedByDescending()은 컬렉션을 내림차순으로 정렬한다.
    products.sortedByDescending { it.price } eq
            "[Product(description=wine, price=5.0)," +
            " Product(description=bread, price=2.0)]"

    products.minByOrNull { it.price } eq Product("bread", 2.0)
}
