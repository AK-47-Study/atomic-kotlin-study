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

        when (val c = c) {
            is Human -> c.greeting()
            is Dog -> c.bark()
            is Alien -> c.mobility()
        }
    }
}
