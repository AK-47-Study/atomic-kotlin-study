package objects
import Test.eq

// object는 함수 안에 넣을 수 없지만, 다른 object나 클래스안에 object를 내포시킬 수는 있다.
object Outer {
    object Nested {
        val a = "Outer.Nested.a"
    }
}

class HasObject {
    object Nested {
        val a = "HasObject.Nested.a"
    }
}

fun main() {
    Outer.Nested.a eq "Outer.Nested.a"
    HasObject.Nested.a eq "HasObject.Nested.a"
}