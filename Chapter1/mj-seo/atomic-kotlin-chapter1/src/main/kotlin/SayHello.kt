

/*
*  반환 값이 없는 Kotlin의 함수는 반환 타입이 Unit 이지만, 이는 생략할 수 있다.
* */
fun sayHello() {
    println("Hello!")
}

fun sayGoodBye(): Unit {
    println("Auf Wiedersehen!")
}

fun main() {
    sayHello()
    sayGoodBye()
}