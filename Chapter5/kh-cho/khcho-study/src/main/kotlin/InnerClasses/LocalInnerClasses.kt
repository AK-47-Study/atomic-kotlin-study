package Chapter5.`kh-cho`.`khcho-study`.src.main.kotlin.InnerClasses

import atomictest.eq

fun interface Pet {
    fun speak(): String
}
object CreatePet {
    fun home() = " home!"
    fun dog(): Pet {
        val say = "Bark"

        // 지역 내부 클래스
        class Dog : Pet {
            override fun speak() = say + home()
        }
        return Dog()
    }

    fun cat(): Pet {
        val emit = "Meow"
        // 익명 내부 클래스
        return object : Pet {
            override fun speak() = emit + home()
        }
    }

    fun hamster(): Pet {
        val squeak = "Squeak"
        return Pet { squeak + home() }
    }
}
fun main() {
    CreatePet.dog().speak() eq "Bark home!"
    CreatePet.cat().speak() eq "Meow home!"
    CreatePet.hamster().speak() eq "Squeak home!"
}