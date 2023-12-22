package memberreferences2

import Test.eq


fun ignore(message: Message) =
    !message.isImportant() &&
            message.sender in setOf("Boss", "Mom")

fun main() {
    val text = "Let's discuss goals " +
            "for the next year"

    val msgs = listOf(
        Message("Boss", text, false, listOf()),
        Message("Boss", text, false, listOf(
           AttachMent("image", "cute cats"))))

    // 최상위 수준 함수에 대한 참조를 만들 때는 클래스 이름이 없으므로 ::function(함수명)처럼 써야한다.
    msgs.filter(::ignore).size eq 1
    msgs.filterNot(::ignore).size eq 1
}