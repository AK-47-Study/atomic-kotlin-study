package extensionproperties

import atomictest.eq


/*
*  제네릭 인자 타입을 사용하지 않으면 *로 대신할 수 있다.
*  -> *을 스타 프로젝션이라 부르며, 타입 정보를 모두 잃어버린다.
*     List<*>에서 얻은 원소는 Any? 에만 대입가능하다.
* */
val List<*>.indices: IntRange
    get() = 0 until size


fun main() {
    listOf(1).indices eq 0..0
    listOf('a', 'b', 'c', 'd').indices eq 0..3
    emptyList<Int>().indices eq IntRange.EMPTY
}