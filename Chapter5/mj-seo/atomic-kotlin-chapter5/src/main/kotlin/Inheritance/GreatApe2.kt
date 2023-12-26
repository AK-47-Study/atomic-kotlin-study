package inheritance.ape2

import Test.eq


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
        // 부모 클래스의 프로퍼티를 변경한다.
        energy += 10
        // 부모 클래스의 함수를 호출
        super.eat()
    }

    fun run() = "Bonobo run"
}

class Chimpanzee : GreatApe() {
    // 새 프로퍼티 추가
    val additionalEnergy = 20
    override fun call() = "Yawp!"
    override fun eat() {
        energy += additionalEnergy
        super.eat()
    }

    fun jump() = "Chimp jump"
}

fun talk(ape: GreatApe): String {
//    ape.run()           ape의 함수가 아니다.
//    ape.jump()          ape의 함수가 아니다.
    ape.eat()
    ape.climb(10)
    return "${ape.call()} ${ape.energyLevel()}"
}

fun main() {
    // energy 프로퍼티에 직접 접근은 불가능하다.
//    GreatApe().energy

    talk(GreatApe()) eq "Hoo! Energy: 0"
    talk(Bonobo()) eq "Eep! Energy: 10"
    talk(Chimpanzee()) eq "Yawp! Energy: 20"
}