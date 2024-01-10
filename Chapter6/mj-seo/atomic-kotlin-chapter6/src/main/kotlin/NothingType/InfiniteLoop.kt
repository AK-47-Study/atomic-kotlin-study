package nothingtype


// Nothing은 함수가 결코 반환되지 않는다는 사실을 표현하는 반환 타입이다.
fun infinite(): Nothing {
    while (true) {}
}