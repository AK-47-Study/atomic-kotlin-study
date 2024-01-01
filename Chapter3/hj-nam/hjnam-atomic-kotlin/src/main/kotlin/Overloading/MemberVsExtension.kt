package overloading
import atomictest.eq

class My {
    fun foo() = 0 // 멤버 함수
}

fun My.foo() = 1 // 멤버 함수와 시그니처가 중복 -> 결코 호출될 수 없음

fun My.foo(i:Int) = i + 2 // 다른 파라미터 목록을 제공 -> 멤버 함수를 확장 함수로 오버로딩 가능

fun main() {
    My().foo() eq 0
    My().foo(1) eq 3
}