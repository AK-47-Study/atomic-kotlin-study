package slowfibonacci

import Test.eq


fun fibonacci(n: Long): Long {
    return when (n) {
        0L -> 0
        1L -> 1
        else ->
            fibonacci(n - 1) + fibonacci(n - 2)
    }
}

fun main() {
    fibonacci(0) eq 0
    fibonacci(22) eq 17711
    // 시간이 아주 오래 걸린다 -> 이전에 계산한 값을 재사용하지 않아서 기하급수적으로 연산 횟수가 증가한다.
    fibonacci(50) eq 12586269025
}