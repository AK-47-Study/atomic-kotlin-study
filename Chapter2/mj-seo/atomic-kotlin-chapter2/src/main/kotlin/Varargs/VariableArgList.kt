


fun v(s: String, vararg d: Double) {}

/*
*  Java에서는 가변 인자를 맨 뒤의 파라미터로만 받을 수 있으나,
*  Kotlin은 가변 인자 파라미터가 한 개이기만 선언은 위치와 상관없이 가능하다.
*  다만, 실행은 되지 않는다. Java같이 마지막 파라미터로만 가능하다.
* */
fun s(vararg d: Double, s: String) {}

fun z(s: String, vararg d: Double, i: Int) {}

fun main() {
    v("abc", 1.0, 2.0)
    v("def", 1.0, 2.0, 3.0, 4.0)
    v("ghi", 1.0, 2.0, 3.0, 4.0, 5.0, 6.0)
}