package creatinggenerics


// 실체화를 사용하면 is를 제네릭 파라미터 타입에 적용할 수 있다.
inline fun <reified T> check(t: Any) = t is T

// 에러! -> 실행 시점에 타입 정보가 유지되지 않는다.
//fun <T> check1(t: Any) = t is T