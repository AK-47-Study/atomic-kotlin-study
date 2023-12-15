package Visibility

class Cookie(
    private var isReady: Boolean
) {
    private fun crumble() =
        println("crumble")


    // 접근 변경자가 없으면 무조건 public 이므로, public 키워드는 쓰지 않아도 된다.
    public fun bite() =
        println("bite")

    fun eat() {
        isReady = true
        crumble()
        bite()
    }
}

fun main() {
    val x = Cookie(false)
    x.bite()

    // private 멤버에는 접근할 수 없다 -> eat(), crumble() 함수에는 접근 불가
    x.eat()
}