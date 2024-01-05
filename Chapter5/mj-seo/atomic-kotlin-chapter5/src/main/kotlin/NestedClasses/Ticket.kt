package nestedclasses
import Test.eq
import nestedclasses.Ticket.Seat.*

class Ticket(
    val name: String,
    val seat: Seat = Coach
) {
    enum class Seat {
        Coach,
        Premium,
        Business,
        First
    }

    fun upgrade(): Ticket {
        val newSeat = entries[
            (seat.ordinal + 1)
                // seat의 ordinal 값에 1을 더해도 First.ordinal을 넘기지 않는다는 사실을 coerceAtMost 함수로 검증한다.
                .coerceAtMost(First.ordinal)
        ]
        return Ticket(name, newSeat)
    }

    fun meal() = when (seat) {
        Coach -> "Bag Meal"
        Premium -> "Bag Meal with Cookie"
        Business -> "Hot Meal"
        First -> "Private Chef"
    }

    override fun toString() = "$seat"
}

fun main() {
    val tickets = listOf(
        Ticket("Jerry"),
        Ticket("Summer", Premium),
        Ticket("Squanchy", Business),
        Ticket("Beth", First)
    )

    tickets.map(Ticket::meal) eq
            "[Bag Meal, Bag Meal with Cookie, " +
            "Hot Meal, Private Chef]"

    tickets.map(Ticket::upgrade) eq
            "[Premium, Business, First, First]"

    tickets eq
            "[Coach, Premium, Business, First]"

    tickets.map(Ticket::meal) eq
            "[Bag Meal, Bag Meal with Cookie, " +
            "Hot Meal, Private Chef]"


}