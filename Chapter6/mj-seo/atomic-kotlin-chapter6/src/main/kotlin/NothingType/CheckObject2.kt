package nothingtype


fun failWithBadData(obj: Any?): Nothing =
    throw BadData("Needs String, got $obj")

// obj를 String으로 변환할 수 있는 경우 String으로 변환한 값을 돌려주고, 그렇지 않은 경우 예외를 던진다.
fun checkObject2(obj: Any?): String =
    (obj as? String) ?: failWithBadData(obj)

fun main() {
    test(::checkObject2)
}