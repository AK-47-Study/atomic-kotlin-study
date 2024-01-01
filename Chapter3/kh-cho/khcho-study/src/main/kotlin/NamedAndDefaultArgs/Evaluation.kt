package Chapter3.`kh-cho`.`khcho-study`.src.main.kotlin.NamedAndDefaultArgs

class DefaultArg
val da = DefaultArg()
fun g(d: DefaultArg = da) = println(d)
fun h(d: DefaultArg = DefaultArg())=
    println(d)
fun main() {
    g()
    g()
    h()
    h()
}