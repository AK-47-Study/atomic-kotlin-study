package dataclasses

import atomictest.eq


data class Simple(
    /*
    *  모든 생성자 파라미터는 var 또는 val로 선언해야 한다.
    * */
    val arg1: String,
    var arg2: Int,
)

fun main() {
    val s1 = Simple("Hi", 29)
    val s2 = Simple("Hi", 29)

    s1 eq "Simple(arg1=Hi, arg2=29)"
    s1 eq s2
}