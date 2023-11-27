
fun main() {
    val num = 10
    /*
    *  Kotlin 에는 삼항 연산자가 없어서 if 문장을 식으로 사용해 결과를 받아야한다.
    * */
    val result = if (num > 100) 4 else 42

    println(result)
}