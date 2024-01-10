package multipleinheritance2


interface Animal
interface Mammal: Animal
interface AquaticAnimal: Animal

class Dolphin: Mammal, AquaticAnimal //다중 인터페이스는 상속 허용

