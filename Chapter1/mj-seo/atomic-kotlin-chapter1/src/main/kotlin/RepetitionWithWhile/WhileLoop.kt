package RepetitionWithWhile

fun condition(i: Int) = i < 100

fun main() {
    var i = 0

    /*
    *  condition 함수가 true를 반환하는 동안 본문의 코드가 반복된다.
    * */
    while (condition(i)) {
        print(".")
        i += 10
    }
}
