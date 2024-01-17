package variance


fun main() {
    val carList: List<Cat> = listOf(Cat())

    // 읽기 전용 리스트는 공변이기 때문에, List<Cat>을 List<Pet>에 대입할 수 있다.
    val petList: List<Pet> = carList
    var mutablePetList: MutableList<Pet> =
        mutableListOf(Cat())

    mutablePetList.add(Dog())

    // 타입 불일치
//    mutablePetList = mutableListOf<Cat>(Cat())
}