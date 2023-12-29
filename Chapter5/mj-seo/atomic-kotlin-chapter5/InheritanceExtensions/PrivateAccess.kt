package inheritanceextensions


class Z(var i: Int = 0) {
    private var j = 0
    fun increment() {
        i++
        j++
    }
}

fun Z.decrement() {
    i--
    // j가 private 이므로 접근이 불가능하다.
//    j--
}