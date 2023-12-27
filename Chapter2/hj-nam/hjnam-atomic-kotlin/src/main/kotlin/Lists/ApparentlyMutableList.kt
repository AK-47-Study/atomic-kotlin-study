import atomictest.eq

fun main() {
    var list = listOf('X')
    list += 'Y'
    list eq "[X, Y]"
}