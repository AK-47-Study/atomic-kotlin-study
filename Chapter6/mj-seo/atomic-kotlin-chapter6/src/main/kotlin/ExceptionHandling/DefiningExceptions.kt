package exceptionhandling
import Test.capture


// 표준 라이브러리의 예외로 충분하지 못한 경우에, Exception의 하위 타입을 상속한 새 예외 타입을 정의할 수 있다.
class Exception1(
    val value: Int
) : Exception("wrong value: $value")

open class Exception2(
    description: String
) : Exception(description)

class Exception3(
    description: String
) : Exception2(description)

fun main() {
    capture {
        throw Exception1(13)
    } eq "Exception1: wrong value: 13"

    capture {
        throw Exception3("error")
    } eq "Exception3: error"
}