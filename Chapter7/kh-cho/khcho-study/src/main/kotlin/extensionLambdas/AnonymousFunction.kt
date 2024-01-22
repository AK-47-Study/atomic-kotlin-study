package Chapter7.`kh-cho`.`khcho-study`.src.main.kotlin.extensionLambdas

fun exec(
    arg1: Int, arg2: Int,
    f: Int.(Int) -> Boolean
) = arg1.f(arg2)

fun main() {
    exec(10, 2, fun Int.(d: Int): Boolean{
        return this % d ==0
    })
}