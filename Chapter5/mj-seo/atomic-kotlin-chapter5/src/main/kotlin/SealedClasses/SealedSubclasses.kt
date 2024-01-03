package sealedclasses

import Test.eq


sealed class Top
class Middle1 : Top()
class Middle2 : Top()
open class Middle3 : Top()
class Bottom3 : Middle3()


fun main() {
    /*
    *  Top::class는 Top에 대한 클래스 객체를 돌려준다.
    *  -> sealedSubclasses 프로퍼티는 대상 클래스 객체가 sealed class일 경우 모든 하위 클래스를 리스트에 담아 반환한다.
    *     만약 sealed class가 아니라면 빈 리스트를 반환한다.
    *     Top의 직접적인 하위 클래스만 리스트에 들어있다는 것에 주의해야 한다(Level 3 이상의 하위 클래스는 안나온다)
    * */
    Top::class.sealedSubclasses
        .map { it.simpleName } eq
            "[Middle1, Middle2, Middle3]"
}