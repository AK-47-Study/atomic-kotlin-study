package IfExpressions

fun oneOrTheOther(exp: Boolean): String =
    if (exp)
        "True"
    else
        "False"

fun main() {
    var x = 1
    println(oneOrTheOther(x == 1))
    println(oneOrTheOther(x == 2))
}