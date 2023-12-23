import Test.eq


fun main() {
    val left = listOf("a", "b", "c", "d")
    val right = listOf("q", "r", "s", "t")

    // left와 right 묶으면 Pair로 이뤄진 List를 만든다 -> left와 right에서 같은 위치에 있는 원소를 결합한다.
    left.zip(right) eq "[(a, q), (b, r), (c, s), (d, t)]"

    // List와 범위를 zip() 하는 것도 가능하다.
    left.zip(0..4) eq "[(a, 0), (b, 1), (c, 2), (d, 3)]"

    // 서로 범위가 다르지만, 한 쪽이 먼저 끝나면 묶기 연산도 종료된다.
    (10..100).zip(right) eq "[(10, q), (11, r), (12, s), (13, t)]"
}