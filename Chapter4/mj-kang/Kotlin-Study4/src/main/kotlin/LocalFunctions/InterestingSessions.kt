package localfunctions

import localfunctions.*
import atomictest.eq


fun main() {

    val lambdaFunction: (Session) -> Boolean =
        { (it.title.contains("Kotlin") && it.speaker in favoriteSpeakers) }

    sessions.any(
        fun(session: Session): Boolean {
            if (session.title.contains("Kotlin") &&
                session.speaker in favoriteSpeakers) {
                return true
            }
            return false
        }) eq true

    sessions.any(lambdaFunction) eq true
}