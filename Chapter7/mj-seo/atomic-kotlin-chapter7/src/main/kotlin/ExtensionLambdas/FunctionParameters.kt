package extensionlambdas


class A {
    fun af() = 1
}

class B {
    fun bf() = 2
}

// 함수의 파라미터로 확장 람다가 사용되는 경우가 더 일반적이다.
fun f1(lambda: (A, B) -> Int) =
    lambda(A(),B())

fun f2(lambda: A.(B) -> Int) =
    A().lambda(B())

fun main() {
    f1 { aa, bb -> aa.af() + bb.bf() }

    // 확장 람다의 반환 타입이 Unit이면 람다 본문이 만들어낸 결과는 무시된다.
    f2 { af() + it.bf() }
}