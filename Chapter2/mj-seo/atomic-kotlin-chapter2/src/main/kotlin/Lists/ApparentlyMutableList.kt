import atomictest.eq


fun main() {
    // 불변 리스트
    var list = listOf('X')
    // 가변 리스트 처럼 보인다.
    list += 'Y'
    list eq "[X, Y]"
}