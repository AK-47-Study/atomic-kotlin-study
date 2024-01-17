package creatinggenerics

import kotlin.random.Random


private val rnd = Random(47)

// 제네릭스를 쓰지 않았기때문에, Disposable만 만들어 낼 수 있다.
fun List<Disposable>.aRandom(): Disposable =
    this[rnd.nextInt(size)]

// 제약은 걸었지만, Disposable의 멤버를 전혀 쓰고있지 않기 때문에 cRandom()과 같아진다.
fun <T: Disposable> List<T>.bRandom(): T =
    this[rnd.nextInt(size)]

fun <T> List<T>.cRandom(): T =
    this[rnd.nextInt(size)]

fun sameReturnType() {
    val a: Disposable = recyclables.aRandom()
    val b: Recyclable = recyclables.bRandom()
    val c: Recyclable = recyclables.cRandom()
}

