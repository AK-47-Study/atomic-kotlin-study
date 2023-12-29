package abstractclasses


abstract class WithProperty {
    /*
    *  초기화 코드가 없으면 참조를 abstract로 선언해야 한다.
    *  -> 초기화 코드가 없으면 타입을 추론할 수 없으므로 타입을 지정해야 한다.
    */
    abstract val x: Int
}

abstract class WithFunctions {
    abstract fun f(): Int

    // abstract 함수의 반환 타입을 적지 않는 경우 반환타입을 Unit으로 간주한다.
    abstract fun g(n: Double)
}

