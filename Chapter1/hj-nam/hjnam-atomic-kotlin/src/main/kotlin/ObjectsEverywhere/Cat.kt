package ObjectsEverywhere

fun main() {
    val cat = Cat()
    // 'cat'에 대해 'meow()'를 호출
    val m1 = cat.meow()
    println(m1)
}

class Cat {
    fun meow() = "mrrrow!"
}
