package extensionfunctions

import atomictest.eq


class Book(val title: String)

/*
*  확장 함수는 확장 대상 타입의 public 원소에만 접근 가능하다.
*  -> 확장 함수는 일반 함수가 할 수 있는 일만 처리할 수 있다.
* */
fun Book.categorize(category: String) =
    """title: "$title", category: $category"""

fun main() {
    Book("Dracula").categorize("Vampire") eq
            """title: "Dracula", category: Vampire"""
}