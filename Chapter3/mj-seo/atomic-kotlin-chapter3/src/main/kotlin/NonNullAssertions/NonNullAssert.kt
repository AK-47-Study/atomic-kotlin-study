import atomictest.*


fun main() {
    var x: String? = "abc"

    /*
    *  x!!는 'x가 null이 아니라는 것을 보증한다'는 뜻이다.
    *  -> null 아님 단언 이라고 표현한다.
    * */
    x!! eq "abc"
    x = null

    capture {
        val s: String = x!!
    } eq "NullPointerException"
}

