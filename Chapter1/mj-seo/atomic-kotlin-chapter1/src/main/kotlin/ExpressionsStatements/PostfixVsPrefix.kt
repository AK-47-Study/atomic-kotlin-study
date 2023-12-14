package ExpressionsStatements


fun main() {
    /*
    *  후위 연산자는 피 연산자 다음에 위치하며, 변숫값을 증가시키기 직전에
    *  i에 들어있던 값을 돌려준다.
    * */
    var i = 10
    println(i++)
    println(i)

    /*
    * 전위 연산자는 먼저 j 값을 증가 시키고, 증가시킨 결과값을 돌려준다.
    * */
    var j = 20
    println(++j)
    println(j)
}