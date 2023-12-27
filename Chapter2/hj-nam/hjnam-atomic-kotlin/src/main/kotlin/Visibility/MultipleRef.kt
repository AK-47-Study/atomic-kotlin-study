package Visibility

class Counter(var start: Int) {
    fun increment() {
        start += 1
    }
    override fun toString() = start.toString()
}

class CounterHolder(counter: Counter) {
    private val ctr = counter
    override fun toString() =
        "CounterHolder: " + ctr
}

fun main() {
    val c = Counter(11)
    val ch = CounterHolder(c)
    println(ch)
    c.increment() // ch 안에서는 private로 인식되는 Counter를 여전히 c를 통해 조작 가능 => c는 public이기 때문
    println(ch)
    val ch2 = CounterHolder(Counter(9)) // Counter(9)를 가리키는 참조가 없으므로 조작도 불가능
    println(ch2)
}