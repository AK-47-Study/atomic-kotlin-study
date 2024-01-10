package inheritance.ape2

import atomictest.eq


open class GreatApe {
    protected var energy = 0
    open fun call() = "Hoo!"
    open fun eat() {
        energy += 10
    }

    // open 키워드가 붙어있지 않은 함수는 오버라이드 할 수 없다.
    fun climb(x: Int) {
        energy -= x
    }

    fun energyLevel() = "Energy: $energy"
}

class Bonobo: GreatApe() {
    override fun call() = "Eep!"
    override fun eat() {
        energy += 10
        super.eat()
    }

    fun run() = "Bonobo run"
}

class Chimpanzee : GreatApe() {

    val additionalEnergy = 20
    override fun call() = "Yawp!"
    override fun eat() {
        energy += additionalEnergy
        super.eat()
    }

    fun jump() = "Chimp jump"
}

fun talk(ape: GreatApe): String {

    ape.eat()
    ape.climb(10)
    return "${ape.call()} ${ape.energyLevel()}"
}

fun main() {

    talk(GreatApe()) eq "Hoo! Energy: 0"
    talk(Bonobo()) eq "Eep! Energy: 10"
    talk(Chimpanzee()) eq "Yawp! Energy: 20"
}

