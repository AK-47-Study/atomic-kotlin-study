package tailrecursion

import Test.eq


/*
*  accumulator 파라미터를 추가해서 재귀 호출 중에 덧셈을 할 수 있게 되었고,
*  결과를 받으면 반환하는 일 말고는 할 일이 없어졌다.
*  -> 재작성한 함수가 모든 연산을 재귀 함수 호출에 위임하기 때문에 tailrec 키워드는 성공한다.
*     accumulator 또한 불변값이 된다.
* */
private tailrec fun sum(
    n: Long,
    accumulator: Long
): Long =
    if (n == 0L) accumulator
    else sum(n -1, accumulator + n)

fun sum(n: Long) = sum(n, 0)

fun main() {
    sum(2) eq 3
    sum(10000) eq 50005000
    sum(100000) eq 5000050000
}