import upcasting.*


fun main() {
    val shape1: Shape = Square()
    val shape2: Shape = Triangle()

    // 컴파일되지 않는다 -> 업캐스트 한 다음에는 기반 타입의 멤버만 호출할 수 있다.
//    shape1.color()
//    shape2.rotate()
}