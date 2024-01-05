package nestedclasses

import Test.eq
import nestedclasses.Airport.Plane


class Airport(private val code: String) {
    open class Plane {
        // 자신을 둘러싼 클래스의 private 프로퍼티에 접근할 수 있다.
        fun contact(airport: Airport) =
            "Contacting ${airport.code}"
    }
    private class PrivatePlane : Plane()
    fun privatePlane() : Plane = PrivatePlane()
}

fun main() {
    val denver = Airport("DEN")
    var plane = Plane()

    plane.contact(denver) eq "Contacting DEN"

    // Private 접근 제어를 가진 내포된 클래스는 접근할 수 없다.
//    val privatePlane = Airport.PrivatePlane()

    val frankfurt = Airport("FRA")
    plane = frankfurt.privatePlane()

    // Private 접근 제어를 가진 내포된 클래스로 다운캐스팅 할 수 없다.
//    val p = plane as PrivatePlane

    plane.contact(frankfurt) eq "Contacting FRA"
}