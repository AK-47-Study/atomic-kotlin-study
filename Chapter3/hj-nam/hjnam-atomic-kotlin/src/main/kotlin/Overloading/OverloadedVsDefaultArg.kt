package overloadingvsdefaultargs
import atomictest.*

fun foo(n: Int = 99) = trace("foo-1-$n")

fun foo() {
    trace("foo-2")
    foo(14)
}

fun main() {
    foo() // 파라미터가 없어 함수 시그니처가 가장 비슷한 두번째 버전의 foo()를 호출
    trace eq """
        foo-2
        foo-1-14
    """
}