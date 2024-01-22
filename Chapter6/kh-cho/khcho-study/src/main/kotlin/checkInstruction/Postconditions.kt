package Chapter6.`kh-cho`.`khcho-study`.src.main.kotlin.checkInstruction

import Chapter6.`kh-cho`.`khcho-study`.src.main.kotlin.capture

val resultFile = DataFile("Results.txt")

fun createResultFile(create: Boolean) {
    if (create)
        resultFile.writeText("Results\n# ok")
    check(resultFile.exists()){
        "${resultFile.name} doesn't exits!"
    }
}

fun main() {
    resultFile.erase()
    capture {
        createResultFile(false)
    } eq "IllegalStateException: "+
            "Results.txt doesn't exist!"
    createResultFile(true)
}