package Chapter7.`kh-cho`.`khcho-study`.src.main.kotlin.extensionLambdas

class A {
    fun af() =1
}

class B {
    fun bf() =2
}

fun f1(lambda: (A, B) -> Int) =
    lambda(A(), B())

fun f2(lambda: A.(B) -> Int) =
    A().lambda(B())

fun main() {
    f1 {aa, bb -> aa.af() + bb.bf()}
    f2 {af() + it.bf()}
}