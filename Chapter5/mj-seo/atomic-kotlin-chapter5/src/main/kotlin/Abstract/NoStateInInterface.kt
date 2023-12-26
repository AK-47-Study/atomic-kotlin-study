package abstractclasses


interface IntList {
    val name: String

    // 컴파일되지 않는다 -> 인터페이스 안에서 프로퍼티에 값을 저장하는 것은 금지되어 있다.
//    val list = listOf(0)
}