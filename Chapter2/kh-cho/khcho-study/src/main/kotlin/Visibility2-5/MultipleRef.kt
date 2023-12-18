package Chapter2.`kh-cho`.`khcho-study`.src.main.kotlin.`Visibility2-5`

class Counter(var start: Int) {
    fun increment() {
        start += 1
    }

    override fun toString() = start.toString()
}
        class CounterHolder(counter: Counter) {
            private val ctr = counter
            override fun toString() =
                "CounterHolder： " + ctr
        }
fun main() {
    val c = Counter(11) // [1]
    val ch = CounterHolder(c) // [2]
    println(ch)
    c.increment() // [3]
    println(ch)
    val ch2 = CounterHolder(Counter(9)) // [4]
    println(ch2)
}