package checkinstructions

import Test.eq
import java.io.File
import java.nio.file.Paths


val targetDir = File("DataFiles")

class DataFile(val fileName: String) :
        File(targetDir, fileName)
{
            init {
                if (!targetDir.exists()) {
                    targetDir.mkdir()
                }
            }
            fun erase() { if (exists()) delete() }
            fun reset(): File {
                erase()
                createNewFile()
                return this
            }
        }

fun main() {
    DataFile("Test.txt").reset() eq
            Paths.get("DataFiles", "Test.txt")
                .toString()
}

