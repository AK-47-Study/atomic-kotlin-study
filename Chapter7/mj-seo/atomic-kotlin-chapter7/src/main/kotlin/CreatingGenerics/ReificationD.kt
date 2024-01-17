package creatinggenerics


inline fun <reified T: Any> d() = a(T::class)

/*
*  reified는 타입 인자의 타입 정보를 유지한다.
*  -> 실행 시점에도 타입 정보를 사용할 수 있기 때문에 함수 본문 안에서도 쓸 수 있다.
*/
val kd = d<K>()