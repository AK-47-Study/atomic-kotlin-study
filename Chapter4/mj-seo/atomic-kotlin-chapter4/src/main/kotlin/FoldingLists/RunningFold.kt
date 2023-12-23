import Test.eq


fun main() {
    val list = listOf(11, 13, 17, 19)
    list.fold(7) { sum, n ->
        sum + n
    } eq 67

    // 초기값(7)을 저장하고, 각각의 중간 단계 값을 추가한다.
    list.runningFold(7) { sum, n ->
        sum + n
    } eq "[7, 18, 31, 48, 67]"

    list.reduce { sum, n ->
        sum + n
    } eq 60

    // 각 sum의 값을 저장한다.
    list.runningReduce { sum, n ->
        sum + n
    } eq "[11, 24, 41, 60]"
}