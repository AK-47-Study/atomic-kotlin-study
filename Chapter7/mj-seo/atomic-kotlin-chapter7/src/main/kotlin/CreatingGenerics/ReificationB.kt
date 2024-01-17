package creatinggenerics


// 타입 소거로 인해 컴파일되지 않는다 -> 실행할 때는 타입 정보 T가 지워지기 때문이다.
//fun <T: Any> b() = a(T::class)