package color3

import atomictest.eq


class Color(
    private val red: Int = 0,
    private val green: Int = 0,
    private val blue: Int = 0,
) {
    override fun toString() =
        "($red, $green, $blue)"
}

/*
*  이름 붙은 인자와 디폴트 인자, 덧붙은 콤마는
*  생성자에 써도 된다.
* */
fun main() {
    Color(red = 77).toString() eq "(77, 0, 0)"
}