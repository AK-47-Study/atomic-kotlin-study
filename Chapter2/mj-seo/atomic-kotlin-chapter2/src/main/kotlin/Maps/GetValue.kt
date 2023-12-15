import atomictest.capture
import atomictest.eq


fun main() {
    val map = mapOf('a' to "attempt")
    map['b'] eq null

    capture {
        map.getValue('b')
    } eq "NoSuchElementException: " +
            "Key b is missing in the map."

    /*
    *  일반적으로 getOrDefault()가 null을 반환하거나 예외를 던지는 함수보다
    *  더 나은 대안이다.
    * */
    map.getOrDefault('a', "??") eq "attempt"
    map.getOrDefault('b', "??") eq "??"
}