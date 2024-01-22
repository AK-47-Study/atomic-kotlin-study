import Test.eq


fun main() {
    var list = listOf(1, 2)
    val initial = list

    // 새로운 값을 추가해도 initial 리스트는 변하지 않는다 -> 리스트를 합친 결과를 생성해서 대입해주기 때문이다.
    list += 3
    list eq "[1, 2, 3]"

    list = list.plus(4)
    list eq "[1, 2, 3, 4]"
    initial eq "[1, 2]"
}