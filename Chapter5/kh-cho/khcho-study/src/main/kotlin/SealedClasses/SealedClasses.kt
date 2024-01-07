package Chapter5.`kh-cho`.`khcho-study`.src.main.kotlin.SealedClasses

import atomictest.eq

sealed class Transports

data class Trains(
    val line: String
): Transports()

data class Buss(
    val number: String,
    val capacity: Int
): Transports()

fun travel(transports: Transports) =
    when(transports) {
        is  Trains ->
            "Train ${transports.line}"
        is Buss ->
            "Bus ${transports.number}" +
                    "size ${transports.capacity}"
    }
fun main() {
    listOf(Trains("S1"), Buss("11", 90))
        .map (::travel) eq
        "[Train S1, Bus 11: size 90]"
}