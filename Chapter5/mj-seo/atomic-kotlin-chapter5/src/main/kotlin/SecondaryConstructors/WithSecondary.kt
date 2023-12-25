package secondaryConstructors

import Test.trace


// 주생성자는 언제나 부생성자에 의해 직접 호출되거나 다른 부생성자 호출을 통해 간접적으로 호출되어야 한다.
class WithSecondary(i: Int) {
    init {
        trace("Primary: $i")
    }

    // 부생성자를 다른 생성자를 호출(this 사용)하는 부분은 생성자 로직 앞에 위치해야 한다.
    constructor(c: Char) : this(c - 'A') {
        trace("Secondary: '$c'")
    }

    constructor(s: String) : this(s.first()) {
        trace("Secondary: \"$s\"")
    }

    /*
    *  주생성자를 호출하지 않으면,
    *  컴파일이 되지 않는다.
    *
    *  constructor(f: Float) {
        trace("Secondary: $f")
       }
    */

}

fun main() {
    fun sep() = trace("_".repeat(10))
    WithSecondary(1)
    sep()
    WithSecondary('D')
    sep()
    WithSecondary("Last Constructor")

    trace eq """
        Primary: 1
        ----------
        Primary: 3
        ----------
        Secondary: 'D'
        ----------
        Primary: 11
        Secondary: 'L'
        Secondary: "Last Constructor"
    """.trimIndent()
}