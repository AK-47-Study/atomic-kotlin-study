import Test.eq


fun main() {
    /*
    *  지역 확장 함수도 정의가 가능하다.
    * */
    fun String.exclaim() = "$this!"
    "Hello".exclaim() eq "Hello!"
    "Hallo".exclaim() eq "Hallo!"
    "Bonjour".exclaim() eq "Bonjour!"
    "Ciao".exclaim() eq "Ciao!"
}