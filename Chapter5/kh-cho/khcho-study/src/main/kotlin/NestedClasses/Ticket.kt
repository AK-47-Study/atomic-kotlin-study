package Chapter5.`kh-cho`.`khcho-study`.src.main.kotlin.NestedClasses

import Chapter5.`kh-cho`.`khcho-study`.src.main.kotlin.NestedClasses.Ticket.Seat.*
import atomictest.eq
import java.time.chrono.JapaneseEra.values

class Ticket (
    val name : String,
    val seat: Seat = Coach
){
    enum class Seat{
        Coach,
        Premium,
        Business,
        First
    }
    fun upgrade(): Ticket{
        val newSeat = values()[
            (seat.ordinal + 1)
                .coerceAtMost(Seat.First.ordinal)
        ]
        return Ticket(name)

    }
    fun meal() = when(seat) {
        Coach ->"Bag Meal"
        Seat.Premium -> "Bag Meal with Cookie"
        Seat.Business -> "Hot Meal"
        Seat.First -> "Private Chef"
    }
    override fun toString( ) = "$seat"
}

fun main() {
    val tickets = listOf(
        Ticket("Jerry"),
        Ticket("Summer", Premium),
        Ticket("Squanchy",Business),
        Ticket("Beth", First)
    )
    tickets.map(Ticket::meal) eq
            "[Bag Meal, Bag Meal whit Cookie, "+
            "Hot Meal , Private Chef]"
}