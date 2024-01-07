package Chapter5.`kh-cho`.`khcho-study`.src.main.kotlin.NestedClasses

import atomictest.eq

class Airport(private val code: String) {
    open class Plane{
        fun contact(airport: Airport) =
            "Contacting ${airport.code}"
    }
    private class PrivatePlane : Plane()
    fun privatePlane(): Plane = PrivatePlane()
}

fun main() {
    val denver = Airport("DEN")
    var plane = Airport.Plane()
    plane.contact(denver) eq  "Contacting DEN"
    val frankfurt = Airport("FRA")
    plane = frankfurt.privatePlane()
    plane.contact(frankfurt) eq "Contacting FRA"
}