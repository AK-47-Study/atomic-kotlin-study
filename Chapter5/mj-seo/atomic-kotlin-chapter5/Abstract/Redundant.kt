package abstractclasses


interface Redundant {
    abstract val x: Int
    abstract fun f(): Int
    abstract fun g(n: Double)
}

interface Removed {
    // 인터페이스에 함수나 프로퍼티를 정의할 때 abstract 키워드는 불필요한 중복이다.
    val x: Int
    fun f(): Int
    fun g(n: Double)
}