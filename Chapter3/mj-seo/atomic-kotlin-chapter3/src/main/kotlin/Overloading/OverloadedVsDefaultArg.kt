package overloadingvsdefaultargs

import atomictest.trace


fun foo(n: Int = 99) = trace("foo-1-$n")

fun foo() {
    trace("foo-2")
    foo(14)
}

/*
*  오버로딩한 함수를 호출하면 함수 시그니처와 함수 호출이
*  '가장 가깝게' 일치되는 함수를 호출한다.
* */
fun main() {
    foo()
    trace eq """
        foo-2
        foo-1-14
    """
}