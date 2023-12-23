import Test.eq
import localfunctions.*


fun main() {
    sessions.any { session ->
        if (session.title.contains("Kotlin") &&
            session.speaker in favoriteSpeakers) {
            // 이 람다가 main()을 반환시키면 안 되므로, 반드시 레이블을 붙여서 람다만 반환시켜야 한다.
            return@any true
        }

        false
    } eq true
}