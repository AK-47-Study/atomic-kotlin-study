package summary2

import atomictest.eq


class Holder(var i: Int)

fun main() {
    val holder = Holder(10)
    holder.i eq 10 // 'i' 프로퍼티 읽기
    holder.i = 20  // 'i' 프로퍼티 값 쓰기
}