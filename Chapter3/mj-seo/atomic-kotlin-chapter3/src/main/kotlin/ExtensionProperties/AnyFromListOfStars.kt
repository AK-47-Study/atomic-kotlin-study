import atomictest.eq


/*
*  List<*>에 저장된 값이 null이 될 수 있는 타입인지에 대해서도 아무 정보가 없다.
*  -> 그러므로 Any? 타입의 변수에만 대입가능하다.
* */
fun main() {
    val list: List<*> = listOf(1, 2)
    val any: Any? = list[0]
    any eq 1
}