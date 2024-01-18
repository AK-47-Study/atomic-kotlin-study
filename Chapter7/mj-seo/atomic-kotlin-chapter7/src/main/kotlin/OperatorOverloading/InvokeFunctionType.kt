package operatoroverloading

import Test.eq


fun main() {
    val func: (String) -> Int = { it.length }

    func("abc") eq 3
    func.invoke("abc") eq 3

    // 함수 참조가 null이 될 수 있는 참조라면 안전한 접근을 사용해야 한다.
    val nullableFunc: ((String) -> Int)? = null

    if (nullableFunc != null) nullableFunc("abc")

    nullableFunc?.let { it("abc") }
    nullableFunc?.invoke("abc")
}