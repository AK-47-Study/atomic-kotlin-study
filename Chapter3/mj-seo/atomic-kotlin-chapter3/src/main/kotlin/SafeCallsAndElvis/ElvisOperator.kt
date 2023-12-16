import atomictest.eq


fun main() {

    /*
    *  엘비스 연산자는 물음표 뒤에 콜론을 붙인(?:) 연산자다.
    *  -> ?:의 왼쪽 식의 값이 null이 아니면 왼쪽 식의 값이 전체 엘비스 식의 결괏값이 된다.
    * */
    val s1: String? = "abc"
    (s1 ?: "---") eq "abc"
    val s2: String? = null
    (s2 ?: "---") eq "---"
}