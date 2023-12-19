package whenexpressions

import atomictest.eq


fun mixColors(first: String, second: String) =
    /*
    *  Set과 Set을 매치시키는 것도 가능하다.
    * */
    when (setOf(first, second)) {
        setOf("red", "blue") -> "purple"
        setOf("red", "yellow") -> "orange"
        setOf("blue", "yellow") -> "green"
        else -> "unknown"
    }

fun mixColorsListVersion(first: String, second: String) =
    /*
    *  List와 List도 매칭은 가능하지만, 순서가 다를경우 매칭이 되지 않는다.
    * */
    when (listOf(first, second)) {
        listOf("red", "blue") -> "purple"
        listOf("red", "yellow") -> "orange"
        listOf("blue", "yellow") -> "green"
        else -> "unknown"
    }


fun main() {
    mixColors("red", "blue") eq "purple"
    mixColors("blue", "red") eq "purple"
    mixColors("blue", "purple") eq "unknown"


    mixColorsListVersion("red", "blue") eq "purple"
    // 순서가 다르기 때문에 매칭되지 않고, unknown이 나온다.
    mixColorsListVersion("blue", "red") eq "unknown"
    mixColorsListVersion("blue", "purple") eq "unknown"
}