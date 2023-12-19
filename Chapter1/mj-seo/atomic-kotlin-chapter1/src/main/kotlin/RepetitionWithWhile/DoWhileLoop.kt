package RepetitionWithWhile


fun main() {
    var i = 0

    /*
    *  condition 함수가 true를 반환하는 동안 본문의 코드가 반복된다.
    *  do - while 문은 Boolean 식이 false를 돌려줘도 최소 한 번은 실행된다.
    * */
    do {
        print(".")
        i += 10
    } while (condition(i))

}
