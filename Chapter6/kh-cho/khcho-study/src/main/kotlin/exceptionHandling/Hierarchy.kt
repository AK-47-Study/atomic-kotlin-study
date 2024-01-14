package Chapter6.`kh-cho`.`khcho-study`.src.main.kotlin.exceptionHandling

import Chapter6.`kh-cho`.`khcho-study`.src.main.kotlin.eq

fun testCatchOrder(which: Int) =
    try {
        toss(which)
    } catch (e: Exception2){
        "Handler for Exception2 got ${e.message}"
    } catch (e: Exception3){
        "Handler for Exception3 got ${e.message}"
    }

fun main() {
    testCatchOrder(2    ) eq
            "Handler for Exception2 got Exception2"

    testCatchOrder(3) eq
            "Handler for Exception2 got Exception3"
}
