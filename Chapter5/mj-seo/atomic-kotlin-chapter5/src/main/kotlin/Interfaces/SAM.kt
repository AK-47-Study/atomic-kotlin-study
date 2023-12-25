package interfaces


/*
*  Kotlin에서는 SAM(단일 추상 메서드)를 정의하는 fun interface라는 특별한 문법이 있다.
*  Java의 함수형 인터페이스처럼 멤버 함수가 하나만 들어 있어야 SAM 인터페이스가 된다.
* */
fun interface ZeroArg {
    fun f(): Int
}

fun interface OneArg {
    fun g(n: Int): Int
}

fun interface TwoArg {
    fun h(i: Int, j: Int) : Int
}
