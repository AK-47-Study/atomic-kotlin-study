package Chapter6.`kh-cho`.`khcho-study`.src.main.kotlin.resourceCleanup

import Chapter6.`kh-cho`.`khcho-study`.src.main.kotlin.checkInstruction.DataFile
import Chapter6.`kh-cho`.`khcho-study`.src.main.kotlin.trace

fun main() {
    DataFile("Results.txt").forEachLine {
        if (it.startsWith("#"))
            trace("$it")
    }
    trace eq "# ok"
}