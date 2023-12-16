import atomictest.trace


fun main() {
    val yes = "A"
    val no = "B"

    for (choice in listOf(yes, no, yes)) {
        when (choice) {
            yes -> trace("Hooray!")
            no -> trace("Too bad!")
        }

        /*
        *  when 식과 if 식은 기능이 겹치는 부분이 있지만,
        *  when이 더 유연하다.
        * */
        if (choice == yes) trace("Hooray!")
        else if (choice == no) trace("Too bad!")
    }

    trace eq """
        Hooray!
        Hooray!
        Too bad!
        Too bad!
        Hooray!
        Hooray!
    """.trimIndent()
}