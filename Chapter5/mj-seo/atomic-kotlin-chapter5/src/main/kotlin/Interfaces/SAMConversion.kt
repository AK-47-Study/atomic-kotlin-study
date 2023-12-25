package interfaces

import Test.trace


fun interface Action {
    fun act()
}

/*
*  람다를 SAM 인터페이스가 필요한 곳에 넘길 수도 있다.
* */
fun delayAction(action: Action) {
    trace("Delaying...")
    action.act()
}

fun main() {
    delayAction { trace("Hey!") }
    trace eq "Delaying... Hey!"
}