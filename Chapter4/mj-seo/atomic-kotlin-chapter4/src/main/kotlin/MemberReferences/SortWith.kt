import atomictest.eq
import memberreferences1.Message


fun main() {
    val messages = listOf(
        Message("Kitty", "Hey!", true),
        Message("Kitty", "Where are you?", false),
        Message("Boss", "Meeting today", false))

    // 메시지를 읽지 않은 순서대로 정렬하고, 읽은 메시지가 보낸 사람 순서대로 정렬된다.
    messages.sortedWith(compareBy(
        Message::isRead, Message::sender)) eq
            listOf(
                Message("Boss", "Meeting today", false),
                Message("Kitty", "Where are you?", false),
                Message("Kitty", "Hey!", true))
}