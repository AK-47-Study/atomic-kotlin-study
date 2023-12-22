import Test.trace


fun main() {
    // 두 번째 인자로 받은 동작(함수)을 첫 번째 인자로 받은 Int 값이 지정한 횟수만큼 반복한다.
    repeat(4) { trace("hi!") }
    trace eq "hi! hi! hi! hi!"
}