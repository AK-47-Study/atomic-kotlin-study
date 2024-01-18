package operatoroverloading


fun `A long name with spaces`() = Unit

fun `*how* is this working?`() = Unit

fun `'when' is a keyword`() = Unit

// 역작은따옴표로 함수를 감싸는 경우에는 공백, 비 표준 글자, 예약어 등을 사용할 수 있다.
//fun `Illegal characters : <>`() = Unit

fun main() {
    `A long name with spaces`()
    `*how* is this working?`()
    `'when' is a keyword`()
}