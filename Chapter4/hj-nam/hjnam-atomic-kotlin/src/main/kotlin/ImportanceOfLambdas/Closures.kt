import atomictest.eq

fun main() {
    val list = listOf(1, 5, 7, 10)
    val divider = 5
    list.filter { it % divider == 0 } eq // 람다가 자신의 밖에 정의된 divider를 포획함
            listOf(5, 10)
}