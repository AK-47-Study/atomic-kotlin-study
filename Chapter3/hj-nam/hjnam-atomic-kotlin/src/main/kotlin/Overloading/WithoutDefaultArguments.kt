package withoutdefaultarguments
import atomictest.eq

// 디폴트 인자를 흉내 내기 위해 확장 함수를 사용하면 안됨
// 사용하면 안되는 코드
fun f(n: Int) = n + 373
fun f() = f(0) // 위의 함수만 호출하는 역할 밖에 하지 않음

fun main() {
    f() eq 373
}