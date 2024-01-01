package namedanddefault

class DefaultArg
val da = DefaultArg()

fun g(d: DefaultArg = da) = println(d)

fun h(d: DefaultArg = DefaultArg()) =
    println(d)

fun main() {
    g() //namedanddefault.DefaultArg@4c203ea1
    g() //namedanddefault.DefaultArg@4c203ea1
    h() //namedanddefault.DefaultArg@27f674d
    h() //namedanddefault.DefaultArg@1d251891
}