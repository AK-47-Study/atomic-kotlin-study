package variance


val inBoxAny: InBox<Any> = InBox(Any())
val inBoxPet: InBox<Pet> = inBoxAny
val inBoxCat: InBox<Cat> = inBoxAny
val inBoxDog: InBox<Dog> = inBoxAny

fun main() {
    // AnyBox는 Any, Pet, Cat, Dog를 넣어도 안전하다
    inBoxAny.put(Any())
    inBoxPet.put(Pet())
    inBoxAny.put(Cat())
    inBoxAny.put(Dog())

    // PetBox는 Pet, Cat, Dog를 넣어도 안전하다.
    inBoxPet.put(Pet())
    inBoxPet.put(Cat())
    inBoxPet.put(Dog())

    // catBox와 dogBox는 각각 정해진 하나의 타입만 받을 수 있다.
    inBoxCat.put(Cat())
    inBoxDog.put(Dog())
}