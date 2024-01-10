import Test.eq
import checkinstructions.DataFile


fun main() {
    DataFile("Results.txt")
        .bufferedReader()
        // use()를 사용하면 AutoCloseable 인페이스를 구현하는 모든 객체의 close()를 호출한다.
        .use { it.readLines().first() } eq
            "Results"
}