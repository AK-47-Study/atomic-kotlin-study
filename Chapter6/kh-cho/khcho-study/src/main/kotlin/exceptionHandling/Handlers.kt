package Chapter6.`kh-cho`.`khcho-study`.src.main.kotlin.exceptionHandling

import Chapter6.`kh-cho`.`khcho-study`.src.main.kotlin.eq

fun toss(which : Int) = when(which){
    1 -> throw Exception1(1)
    2 -> throw Exception2("Exception2")
    3 -> throw Exception3("Exception3")
    else -> "OK"
}

fun test(which: Int): Any? =
    try {
        toss(which)
    } catch (e: Exception1) {
        e.value
    } catch (e: Exception3) {
        e.message
    } catch (e: Exception2) {
        e.message
    }

fun main() {
    test(0) eq  "OK"
    test(1) eq 1
    test(2) eq "Exception2"
    test(3) eq "Exception3"
}

