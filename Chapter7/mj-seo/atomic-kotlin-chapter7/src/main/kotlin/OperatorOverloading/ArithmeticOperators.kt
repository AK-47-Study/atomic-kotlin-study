package operatoroverloading

import Test.eq


// 단항 연산자
operator fun E.unaryPlus() = E(v)
operator fun E.unaryMinus() = E(-v)
operator fun E.not() = this

// 증가 & 감소 연산자
operator fun E.inc() = E(v + 1)
operator fun E.dec() = E(v - 1)

fun unary(a: E) {
    +a  // unaryPlus()
    -a  // unaryMinus()
    !a  // not()

    var b = a
    b++ // inc() -> var에서만 가능
    b-- // dec() -> var에서만 가능
}

operator fun E.plus(e: E) = E(v + e.v)
operator fun E.minus(e: E) = E(v - e.v)
operator fun E.times(e: E) = E(v * e.v)
operator fun E.div(e: E) = E(v / e.v)
operator fun E.rem(e: E) = E(v % e.v)

fun binary(a: E, b: E) {
    a + b    // plus()
    a - b    // minus()
    a * b   // times()
    a / b   // div()
    a % b   // rem()
}

// 복합 대입 연산자
operator fun E.plusAssign(e: E) { v += e.v }
operator fun E.minusAssign(e: E) { v - e.v }
operator fun E.timesAssign(e: E) { v *= e.v }
operator fun E.divAssign(e: E) { v /= e.v }
operator fun E.remAssign(e: E) { v %= e.v }

fun assignment(a: E, b: E) {
    a += b    // plusAssign()
    a -= b    // minusAssign()
    a *= b   // timesAssign()
    a /= b   // divAssign()
    a %= b   // remAssign
}

fun main() {
    val two = E(2)
    val three = E(3)
    two + three eq E(5)
    two * three eq E(6)
    val thirteen = E(13)
    thirteen / three eq E(4)
    thirteen % three eq E(1)
    val one = E(1)
    one += three * three
    one eq E(10)
}