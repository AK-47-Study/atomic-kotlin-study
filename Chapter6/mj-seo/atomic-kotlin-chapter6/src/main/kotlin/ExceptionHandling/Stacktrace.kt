package stacktrace
import exceptionhandling.Exception1

fun function1(): Int =
    throw Exception1(-52)

fun function2() = function1()

fun function3() = function2()

fun main() {
    // 예외를 처리할 핸들러를 찾지 못하면 콘솔에 스택 트레이스를 출력하고 종료한다.
    function3()
}
