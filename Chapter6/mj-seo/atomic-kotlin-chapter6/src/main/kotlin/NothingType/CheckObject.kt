package nothingtype
import Test.*


class BadData(m: String) : Exception(m)

fun checkObject(obj: Any?): String =
    // Nothing 타입은 String 으로도 취급할 수 있다.
    if (obj is String)
        obj
    else
        // kotlin Nothing 임의의 타입의 하위 타입으로 취급한다.
        throw BadData("Needs String, got $obj")

fun test(checkObj: (obj: Any?) -> String) {
    checkObj("abc") eq "abc"
    capture {
        checkObj(null)
    } eq "BadData: Needs String, got null"

    capture {
        checkObj(123)
    } eq "BadData: Needs String, got 123"
}

fun main() {
    test(::checkObject)
}

