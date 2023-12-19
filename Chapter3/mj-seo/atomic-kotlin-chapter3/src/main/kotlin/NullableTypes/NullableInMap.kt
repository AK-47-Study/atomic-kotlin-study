import atomictest.eq


fun main() {
    /*
    *  kotlin에서는 null이 될 수 있는 타입을 단순히
    *  역참조(멤버 프로퍼티나 멤버 함수에 접근) 할 수 없다.
    * */
    val map = mapOf(0 to "yes", 1 to "no")
    val first: String? = map[0]
    val second: String? = map[2]

    first eq "yes"
    second eq null
}