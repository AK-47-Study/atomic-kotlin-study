package creatinggenerics

import variance.Cat
import variance.OutBox
import variance.Pet


// out을 사용해서 Put을 막으면, catBox를 petBox나 anyBox에 대입하는 대입문이 안전해진다.
val outCatBox: OutBox<Cat> = OutBox(Cat())
val outPetBox: OutBox<Pet> = outCatBox
val outAnyBox: OutBox<Cat> = outCatBox

fun getting() {
    val cat: Cat = outCatBox.get()
    val pet: Pet = outPetBox.get()
    val any:Any = outAnyBox.get()
}