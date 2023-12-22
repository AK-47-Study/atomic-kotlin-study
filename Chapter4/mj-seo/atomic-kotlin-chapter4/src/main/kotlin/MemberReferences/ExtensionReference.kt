package memberreferences

import Test.eq


fun Int.times47() = times(47)

class Frog
fun Frog.speak() = "Ribbit!"

fun goInt(n: Int, g: (Int) -> Int) = g(n)

fun goFrog(frog: Frog, g: (Frog) -> String) =
    g(frog)

fun main() {
    /*
    *  확장 함수에 대한 참조를 만들려면, 참조 앞에
    *  확장 대상 타입 이름을 붙이면 된다.
    * */
    goInt(12, Int::times47) eq 564
    goFrog(Frog(), Frog::speak) eq "Ribbit!"
}