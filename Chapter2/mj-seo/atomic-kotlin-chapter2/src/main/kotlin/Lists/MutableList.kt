import atomictest.eq


fun main() {
    // 처음 List에 아무 원소도 없기 때문에 mutableListOf 다음에 <Int>를 덧붙여야 한다.
    val list = mutableListOf<Int>()

    list.add(1)
    list.addAll(listOf(2, 3))

    // add 또는 addAll 함수를 호출하지 않고 += 로 짧게 쓸 수 있다.
    list += 4
    list += listOf(5, 6)

    list eq listOf(1, 2, 3, 4, 5, 6)
}