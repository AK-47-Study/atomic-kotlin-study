package summary2

import atomictest.eq


val colors =
    "Yellow Green Green Blue"
        .split(Regex("""\W+""")).sorted()

fun main() {
    colors eq
            listOf("Blue", "Green", "Green", "Yellow")
    val colorSet = colors.toSet()

    colorSet eq
            setOf("Yellow", "Green", "Blue")

    /*
    *  합집합, 교집합, 차집합 등의 일반적인 수학 집합 연산도 제공한다.
    * */
    (colorSet + colorSet) eq colorSet
    val mSet = colorSet.toMutableSet()

    mSet -= "Blue"
    mSet += "Red"

    mSet eq setOf("Yellow", "Green", "Red")
    // 집합 원소인지 확인 -> in 또는 contains() 사용
    ("Green" in colorSet) eq true
    colorSet.contains("Red") eq false
}