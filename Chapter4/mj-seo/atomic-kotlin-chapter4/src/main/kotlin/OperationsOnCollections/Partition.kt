import Test.eq


fun main() {
    val list = listOf(-3, -1, 5, 7, 10)
    val isPositive = { i: Int -> i > 0 }

    list.filter(isPositive) eq "[5, 7, 10]"
    list.filterNot(isPositive) eq "[-3, -1]"

    // partition()은 동시에 양쪽 그룹(만족하는 그룹과 아닌 그룹)을 만들어낸다.
    val (pos, neg) = list.partition { it > 0 }
    pos eq "[5, 7, 10]"
    neg eq "[-3, -1]"
}