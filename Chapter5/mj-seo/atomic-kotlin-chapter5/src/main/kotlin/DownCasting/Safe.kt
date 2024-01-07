package downcasting

import Test.eq


fun dogBarkSafe(c: Creature) =
    /*
    *  as?는 실패해도 예외를 던지지 않고, null을 반환한다.
    *  -> NullPointerException을 방지하기 위해서는 엘비스 연산자가 가장 간단하고 직접적인 방법이다.
    * */
    (c as? Dog)?.bark() ?: "Not a Dog"

fun main() {
    dogBarkSafe(Dog()) eq "Yip!"
    dogBarkSafe(Human()) eq "Not a Dog"
}