import Test.eq


fun main() {
    // 반환 타입을 null이 될 수 있는 타입으로 만드는 것
    val returnTypeNullable: (String) -> Int? = { null }

    // 함수 전체의 타입을 null이 될 수 있는 타입으로 만드는 것
    val mightBeNull: ((String) -> Int)? = null
    returnTypeNullable("abc") eq null

    // null-check을 하지 않으면 컴파일도 되지 않는다.
    if (mightBeNull != null) {
        mightBeNull("abc")
    }

}