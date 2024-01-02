package downcasting


class SmartCast1(val c: Creature) {
    fun concat() {
        when (c) {
            is Human -> c.greeting()
            is Dog -> c.bark()
            is Alien -> c.mobility()
        }
    }
}

class SmartCast2(var c: Creature) {
    fun concat() {
        /*
        *  c를 var 가시성을 두어 변경을 허용하게 한다면, 변경되지 않을 것이라고 확신할 수 없기 때문에
        *  코틀린은 타입을 검사하는 시점과 다운캐스트한 타입으로 사용하는 지점 사이에 c의 값이 변하지 않도록 강제한다.
        * */
        when (val c = c) {
            is Human -> c.greeting()
            is Dog -> c.bark()
            is Alien -> c.mobility()
        }
    }
}