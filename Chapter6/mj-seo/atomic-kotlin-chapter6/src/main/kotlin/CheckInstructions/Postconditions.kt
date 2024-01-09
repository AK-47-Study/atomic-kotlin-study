package checkinstructions

import Test.capture


val resultFile = DataFile("Results.txt")

fun createResultFile(create: Boolean) {
    if (create)
        resultFile.writeText("Results\n# ok")

    // require()과 같은 역할을 하지만 IllegalStateException을 던진다는 차이가 있다.
    check(resultFile.exists()) {
        "${resultFile.name} doesn't exist!"
    }
}

fun main() {
    resultFile.erase()
    capture {
        createResultFile(false)
    } eq "IllegalStateException: " +
            "Results.txt doesn't exist!"

    createResultFile(true)
}