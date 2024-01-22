import Test.eq


fun main() {
    var list = listOf(1, 2)

    /*
    *  불변 컬렉션에서는 a += b를 a = a + b로 해석한다
    *  -> 컬렉션 내용을 변경하지 않고 새로운 컬렉션을 생성한 후 var 참조에 대입한다.
    */
    list += 3
    list eq "[1, 2, 3]"
}