package Chapter3.`kh-cho`.`khcho-study`.src.main.kotlin.Enumerations5

import atomictest.trace

fun checkLevel(level: Level) {
    when (level) {
        Level.Overflow -> trace(">» Overflow!")
        Level.Empty -> trace( "Alert： Empty")
            else -> trace("Level $level OK")
        }
    }
fun main() {
    checkLevel(Level.Empty)
    checkLevel(Level.Low)
    checkLevel(Level.Overflow)
    trace eq """
        Alert： Empty
        Level Low OK
        >>> Overflow!
    """
}