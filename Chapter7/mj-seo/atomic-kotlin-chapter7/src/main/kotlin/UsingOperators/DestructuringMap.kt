import Test.eq


fun main() {
    val map = mapOf("a" to 1)
    for ((key, value) in map) {
        key eq "a"
        value eq 1
    }

    for (entry in map) {
        /*
        *  Map의 Entry 타입에는 component1()과 component2() 함수가 모두 정의되어 있다.
        *  -> 추가적으로 data 클래스는 componentN()을 자동으로 만들어주기 때문에 구조 분해 선언을 모든 클래스에 대해 사용할 수 있다.
        */
        val key = entry.component1()
        val value = entry.component2()

        key eq "a"
        value eq 1
    }
}