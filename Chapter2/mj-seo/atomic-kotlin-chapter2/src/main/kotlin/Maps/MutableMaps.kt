import atomictest.eq


fun main() {
    val m =
        mutableMapOf(5 to "five", 6 to "six")

    /*
    *  map[key] = value는 key와 연관된 value를 추가하거나 변경한다.
    * */
    m[5] eq  "five"
    m[5] = "5ive"
    m[5] eq "5ive"

    /*
    *  map += key to value를 통해 Key-Value 쌍을 명시적으로 추가할 수도 있다.
    *  -> mapOf()와 mutableMapOf는 원소가 Map에 전달된 순서를 유지해준다.
    * */
    m += 4 to "four"
    m eq mapOf(5 to "5ive", 4 to "four", 6 to "six")
}