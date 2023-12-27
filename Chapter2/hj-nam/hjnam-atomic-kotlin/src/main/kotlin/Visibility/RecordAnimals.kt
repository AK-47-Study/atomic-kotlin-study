package Visibility

private var index = 0                   // 파일 내 다른 함수나 클래스에서 접근 가능

private class Animal(val name: String)  // 파일 내 다른 함수나 클래스에서 접근 가능

private fun recordAnimal(               // 파일 내 다른 함수나 클래스에서 접근 가능
    animal: Animal
) {
    println("Animal #$index: ${animal.name}")
    index++
}

fun recordAnimals() {
    recordAnimal(Animal("Tiger"))
    recordAnimal(Animal("Antelope"))
}

fun recordAnimalsCount() {
    println("$index animals are here!")
}