package downcasting

import Test.capture
import Test.eq


fun dogBarkUnsafe(c: Creature) =
    (c as Dog).bark()

fun dogBarkUnsafe2(c: Creature): String {
    c as Dog
    c.bark()

    return c.bark() + c.bark()
}

fun main() {
    /*
    *  as는 안전하지 않은 캐스트라고 부른다.
    *  -> as가 실패하면 ClassCastException이 발생한다.
    * */
    dogBarkUnsafe(Dog()) eq "Yip!"
    dogBarkUnsafe2(Dog()) eq "Yip!Yip!"

    (capture {
        dogBarkUnsafe(Human())
    }) contains listOf("ClassCastException")
}