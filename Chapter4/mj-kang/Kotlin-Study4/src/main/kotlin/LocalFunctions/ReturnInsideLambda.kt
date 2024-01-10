package localfunctions

import atomictest.eq
import localfunctions.*


fun main() {
    sessions.any { session ->
        if (session.title.contains("Kotlin") &&
            session.speaker in favoriteSpeakers) {

            return@any true
        }

        false
    } eq true
}