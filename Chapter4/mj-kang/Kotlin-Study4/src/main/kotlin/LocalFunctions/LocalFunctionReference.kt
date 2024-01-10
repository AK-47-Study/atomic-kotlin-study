package localfunctions

import atomictest.eq
import localfunctions.*


fun main() {
    fun interesting(session: Session): Boolean {
        if (session.title.contains("Kotlin") &&
            session.speaker in favoriteSpeakers) {
            return true
        }

        return false
    }

    sessions.any(::interesting) eq true
}