package operatoroverloading

import Test.eq


data class Num(val n: Int)

// 함수 이름으로는 연산자에 따라 미리 정해진 이름만 쓸 수 있다.
operator fun Num.plus(rval: Num) =
    Num(n + rval.n)

fun main() {
    Num(4) + Num(5) eq Num(9)
    Num(4).plus((Num(5))) eq Num(9)
}