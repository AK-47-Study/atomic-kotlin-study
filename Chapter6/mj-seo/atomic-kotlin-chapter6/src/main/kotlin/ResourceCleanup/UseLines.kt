import Test.eq
import checkinstructions.DataFile


fun main() {
    DataFile("Results.txt").useLines {
        // useLines()는 파일을 닫고 람다가 반환하는 결과를 반환한다 -> 서로 다른 it가 들어가는 코드를 작성하면 좋지 않다.
        it.filter { "#" in it }.first()
    } eq "# ok"

    DataFile("Results.txt").useLines { lines ->
        lines.filter { line ->
            "#" in line
        }.first()
    } eq "# ok"
}