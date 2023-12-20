package memberreferences2

import atomictest.eq


data class Message(
    val sender: String,
    val text: String,
    val isRead: Boolean,
    val attachments: List<AttachMent>
)

data class AttachMent(
    val type: String,
    val name: String
)

fun Message.isImportant(): Boolean =
    text.contains("Salary increase") ||
            attachments.any {
                it.type == "image" && it.name.contains("cat")
            }

fun main() {
    val messages = listOf(Message(
        "Boss", "Let's discuss goals " +
        "for next year", false,
        listOf(AttachMent("image", "cute cats"))
    ))

    /*
    *  참조를 만들 수 있는 대상이 멤버 함수로만 제한되어 있지는 않다.
    *  함수 타입이 필요한 곳에 바로 함수를 넘길 수는 없지만 참조는 전달할 수 있다.
    * */
    messages.any(Message::isImportant) eq true
}