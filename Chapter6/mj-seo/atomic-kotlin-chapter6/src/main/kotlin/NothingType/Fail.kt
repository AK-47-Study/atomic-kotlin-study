package nothingtype
import Test.capture

// fail()을 사용하면 오류 처리 전략을 쉽게 변경할 수 있다.
fun fail(i: Int): Nothing =
    throw Exception("fail($i)")

fun main() {
    capture {
        fail(1)
    } eq "Exception: fail(1)"

    capture {
        fail(2)
    } eq "Exception: fail(2)"
}