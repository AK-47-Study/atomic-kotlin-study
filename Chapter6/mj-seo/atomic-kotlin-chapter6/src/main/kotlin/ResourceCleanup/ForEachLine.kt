import Test.trace
import checkinstructions.DataFile


fun main() {
    // forEachLine()에 전달된 람다는 Unit을 반환한다 -> 람다가 부수 효과를 통해 달성해야 한다.
    DataFile("Results.txt").forEachLine {
        if (it.startsWith("#")) {
            trace("$it")
        }
    }

    trace eq "# ok"
}