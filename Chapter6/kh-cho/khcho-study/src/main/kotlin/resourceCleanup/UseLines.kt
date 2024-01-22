package Chapter6.`kh-cho`.`khcho-study`.src.main.kotlin.resourceCleanup

import Chapter6.`kh-cho`.`khcho-study`.src.main.kotlin.checkInstruction.DataFile
import Chapter6.`kh-cho`.`khcho-study`.src.main.kotlin.eq

fun main() {
    DataFile("Results.txt").useLines {
        it.filter { "#" in it }.first()
    } eq "# ok"
    DataFile("Results.txt").useLines {
        lines -> lines.filter {
            line -> "#" in line
        }.first()
    } eq "# ok"
}