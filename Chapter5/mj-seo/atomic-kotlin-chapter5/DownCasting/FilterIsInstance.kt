package downcasting

import Test.eq


fun main() {
    val humans1: List<Creature> =
        group.filter { it is Human }

    humans1.size eq 2

    // 지정한 타입에 속하는 모든 원소를 돌려주는 filterIsInstance()를 사용하면 코드가 간결해진다.
    val humans2: List<Human> =
        group.filterIsInstance<Human>()

    humans2 eq humans1
}