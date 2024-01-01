package introgenerics
import atomictest.eq

data class Automobile(val brand: String)

// 재사용성이 좋지 않음: Automobile 밖에 담지 못함
class RigidHolder(private val a: Automobile){
    fun getValue() = a
}

fun main() {
    val holder = RigidHolder(Automobile("BMW"))
    holder.getValue() eq
            "Automobile(brand=BMW)"
}