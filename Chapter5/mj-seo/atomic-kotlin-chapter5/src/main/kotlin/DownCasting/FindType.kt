package downcasting

import Test.eq


val group: List<Creature> = listOf(
    Human(), Human(), Dog(), Alien(), Dog()
)

fun main() {
    val dog = group
        // Group안에 Dog가 하나도 없을 수 있기 때문에 Dog? 타입으로 변환해야 한다.
        .find { it is Dog } as Dog?

    dog?.bark() eq "Yip!"
}