package LoopingAndRanges


fun main() {
    val s = "abc"

    // s.lastIndex를 읽으면 문자열 s의 마지막 인덱스 값을 알 수 있다.
    for (i in 0..s.lastIndex) {
        print(s[i] + 1)
    }
}