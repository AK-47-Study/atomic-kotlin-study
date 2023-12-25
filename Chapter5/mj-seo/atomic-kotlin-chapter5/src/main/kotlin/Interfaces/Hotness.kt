package interfaces

import Test.eq


interface Hotness {
    fun feedback(): String
}

enum class SpiceLevel : Hotness {
    Mild {
        override fun feedback() = "It adds flavor!"
    },
    Medium {
        override fun feedback() = "Is it warm in here?"
    },
    Hot {
        override fun feedback() = "I'm suddenly sweating a lot."
    },
    Flaming {
        override fun feedback() = "I'm in pain. I am suffering."
    }
}

fun main() {
    // Kotlin 1.9 버전부터 values() 대신 entries를 호출하는 것을 권장한다.
    SpiceLevel.entries.map { it.feedback() } eq
            "[It adds flavor!, " +
            "Is it warm in here?, " +
            "I'm suddenly sweating a lot., " +
            "I'm in pain. I am suffering.]"
}