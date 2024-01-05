package innerclasses
import Test.eq


class Hotel(private val reception: String) {
    open inner class Room(private val id: Int = 0) {
        // Room을 둘러싼 클래스의 'reception'을 사용한다.
        fun callReception() =
            "Room $id Calling $reception"
    }

    // Kotlin은 inner data 클래스를 허용하지 않는다.
    private inner class Closet : Room()
    fun closet(): Room = Closet()
}

fun main() {
    val nyHotel = Hotel("311")

    /*
    *  내부 클래스의 인스턴스를 생성하려면
    *  그 내부 클래스를 둘러싼 클래스의 인스턴스가 필요하다
    */
    val room = nyHotel.Room(319)
    room.callReception() eq
            "Room 319 Calling 311"

    // inner 클래스의 객체를 생성하려면 외부 객체를 제공해야 한다.
    val sfHotel = Hotel("0")
    val closet = sfHotel.closet()

    closet.callReception() eq "Room 0 Calling 0"
}


