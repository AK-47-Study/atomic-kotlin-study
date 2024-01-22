package Chapter6.`kh-cho`.`khcho-study`.src.main.kotlin.resourceCleanup

import Chapter6.`kh-cho`.`khcho-study`.src.main.kotlin.checkInstruction.DataFile
import Chapter6.`kh-cho`.`khcho-study`.src.main.kotlin.eq

fun main() {
    DataFile("Results.txt")
        .bufferedReader()
        .use { it.readLines().first() } eq
            "Results"
}