package Chapter2.`kh-cho`.`khcho-study`.src.main.kotlin.`Visibility2-5`


private var index = 0

private class Animal(val name: String)

private fun recordAnimal(
    animal: Animal
){
    println("animal = ${animal.name}")
}

fun recordAnimals() {
    recordAnimal(Animal("Tiger"))
    recordAnimal(Animal("Antelope"))
}

fun recordAnimalsCount(){
    println("$index animals are here!")
}

fun main() {
    recordAnimals()
    recordAnimalsCount()
}