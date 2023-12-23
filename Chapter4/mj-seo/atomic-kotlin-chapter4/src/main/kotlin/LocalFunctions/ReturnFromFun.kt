import Test.eq


fun main() {
    val list = listOf(1, 2, 3, 4, 5)
    val value = 3

    var result = ""

    list.forEach {
        result += "$it"
        if (it == value) {
            result eq "123"
            /*
            *  원래 코틀린 람다 안에서는 return을 쓸 수 없다.
            *  여기서 return의 의미는 main() 함수를 끝내는 것이다.
            *  -> 코틀린에서는 인라인 함수가 람다를 인자로 받는 경우 해당 람다도 함께 인라인하게 되어있다.
            *     함께 인라인되는 람다 안에서 return을 쓸 수 있도록 허용하고 있다. -> 추가적으로 공부 필요(인라인 함수 문서를 보자)
            * */
            return
        }
    }

    result eq "Never gets here"
}