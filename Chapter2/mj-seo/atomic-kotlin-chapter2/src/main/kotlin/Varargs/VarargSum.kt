import atomictest.eq


/*
*  이 파라미터는 Array로 취급된다.
*  -> 모든 인자는 지정한 타입에 속해야 한다.
* */
fun sum(vararg numbers: Int): Int {
    var total = 0
    for (n in numbers) {
        total += n
    }
    return total
}

fun main() {
    sum(13, 27, 44) eq 84
    sum(1, 3, 5, 7, 9, 11) eq 36
    sum() eq 0
}