import atomictest.trace


fun main() {
    /*
    *  \W는 단어를 이루는 문자가 아닌 문자들이라는 뜻의 특별한 패턴이고,
    *  +는 '앞에 온 패턴을 한 번 이상 반복'이라는 뜻이다.
    * */
    val wocky = """
        Twas brillig, and the slithy toves
          Did gyre and gimble in the wabe:
        All mimsy were the borogoves,
          And the mome raths outgrabe
    """.trim().split(Regex("\\W+"))

    // take(n)은 릐스트의 맨 앞에 있는 n개의 원소가 포함된 새 List를 만든다.
    trace(wocky.take(5))
    /*
    *  slice()는 인자로 전달된 Range에 속하는 인덱스와 일치하는 위치의 원소로 이뤄진 새 List를 만든다.
    *  -> step을 포함시켜도 된다.
    * */
    trace(wocky.slice(6..12))
    trace(wocky.slice(6..18 step 2))

    /*
    *  sorted는 새 리스트를 만들고, sortsms mutableList에 대해서만 작동하며
    *  원본 리스트를 변경한다.
    * */
    trace(wocky.sorted().takeLast(5))
    trace(wocky.sorted().distinct().takeLast(5))

    trace eq """
        [Twas, brillig, and, the, slithy]
        [Did, gyre, and, gimble, in, the, wabe]
        [Did, and, in, wabe, mimsy, the, And]
        [the, the, toves, wabe, were]
        [slithy, the, toves, wabe, were]
    """.trimIndent()
}