import Test.eq


fun main() {
    val list = listOf('a', 'b', 'c', 'X', 'Z')
    // takeLast()와 takeDrop()은 각각 마지막 원소를 취하거나 제거한다.
    list.takeLast(3) eq "[c, X, Z]"
    list.takeLastWhile { it.isUpperCase() } eq "[X, Z]"

    list.drop(1) eq "[b, c, X, Z]"
    list.dropWhile { it.isLowerCase() } eq "[X, Z]"
}