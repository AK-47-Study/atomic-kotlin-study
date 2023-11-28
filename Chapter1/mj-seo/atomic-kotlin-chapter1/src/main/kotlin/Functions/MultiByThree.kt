package Functions
/*
*  함수의 본문이 하나의 식으로만 이뤄진 경우,
*  등호(=) 뒤에 그 식을 넣어서 함수를 짧게 작성할 수 있다.
* */
fun multiByThree(x: Int) : Int = x * 3

fun main() {
    println(multiByThree(5))
}