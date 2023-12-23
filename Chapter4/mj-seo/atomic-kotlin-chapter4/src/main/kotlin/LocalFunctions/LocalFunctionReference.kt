import Test.eq
import localfunctions.*


fun main() {
    fun interesting(session: Session): Boolean {
        if (session.title.contains("Kotlin") &&
            session.speaker in favoriteSpeakers) {
            return true
        }

        return false
    }

    // 함수 참조를 이용해, 지역 함수를 참조할 수 있다.
    sessions.any(::interesting) eq true
}