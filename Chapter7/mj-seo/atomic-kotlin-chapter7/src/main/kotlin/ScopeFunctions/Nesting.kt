package scopefunctions

import Test.eq


fun nesting(s: String, i: Int) =
    // 영역 함수를 내포시키는 경우, 어떤 문맥에서 this나 it 객체를 쓰는지 알아보기 힘들 수 있다.
    with(s) {
        with(i) {
            toString()
        }
    } + s.let {
        i.let {
            it.toString()
        }
    } + s.run {
        i.run {
            toString()
        }
    } + s.apply {
        i.apply {
            toString()
        }
    } + s.also {
        i.also {
            it.toString()
        }
    }

fun main() {
    nesting("X", 7) eq "777XX"
}