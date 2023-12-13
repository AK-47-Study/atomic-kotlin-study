import atomictest.eq


fun main() {
    val mutableSet = mutableSetOf<Int>()
    mutableSet += 42
    mutableSet += 42
    mutableSet eq setOf(42)

    /*
    *  List와 마찬가지로 += 과 -= 연산자는
    *  Set에서 원소를 추가 또는 삭제할 수 있다.
    * */
    mutableSet -= 42
    mutableSet eq setOf()
}