package multipleinheritance2


interface Animal
interface Mammal: Animal
interface AquaticAnimal: Animal

// 다중 인터페이스 상속은 허용한다.
class Dolphin: Mammal, AquaticAnimal