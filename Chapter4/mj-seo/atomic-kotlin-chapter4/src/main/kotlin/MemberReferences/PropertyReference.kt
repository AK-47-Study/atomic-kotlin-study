package memberreferences1

import atomictest.eq


data class Message(
    val sender: String,
    val text: String,
    val isRead: Boolean,
)

fun main() {
    val messages = listOf(
        Message("Kitty", "Hey!", true),
        Message("Kitty", "Where are you?", false))

    /*
    *  클래스 이름과 2중 콜론(::)을 위치시켜서 멤버 참조를 만들 수 있다.
    *  함수, 프로퍼티, 생성자를 호출하는 람다를 대신할 수 있다.
    * */
    val unread =
        messages.filterNot(Message::isRead)

    unread.size eq 1
    unread.single().text eq "Where are you?"
}