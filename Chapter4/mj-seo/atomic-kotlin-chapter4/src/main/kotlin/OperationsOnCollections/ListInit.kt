import atomictest.eq


fun main() {
    val mutableList1 =
        MutableList(5, { 10 * (it + 1) })
    mutableList1 eq "[10, 20, 30, 40, 50]"

    val mutableList2 =
        // 람다가 함수의 마지막 원소인 경우 람다를 인자 목록 밖으로 빼낼 수 있다.
        MutableList(5) { 10 * (it + 1) }
    mutableList2 eq "[10, 20, 30, 40, 50]"
}