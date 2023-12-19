
class Cage2(private val maxCapacity: Int) {
    private val hamsters = mutableListOf<Hamster>()

    /*
    *  모든 함수를 프로퍼티로 변환하지 말고 경우에 따라 프로퍼티로 정의할지 함수로 할지 정한다.
    *  -> 계산 비용이 많이 들지 않고 객체 상태가 바뀌지 않는 한 같은 결과를 내놓느 함수의 경우 프로퍼티를 사용하는 편이 낫다.
    * */
    fun capacity(): Int = maxCapacity - hamsters.size
    fun isFull(): Boolean = hamsters.size == maxCapacity
}