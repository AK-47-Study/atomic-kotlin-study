import localfunctions.*
import Test.eq


fun main() {

    // 람다로 정의하는 것이 불가능 한 건 아니지만, 복잡해서 읽기 어려울 때는 익명 함수 또는 지역 함수로 대신하는 것이 좋다.
    val lambdaFunction: (Session) -> Boolean =
        { (it.title.contains("Kotlin") && it.speaker in favoriteSpeakers) }

    sessions.any(
        /*
        *  interesting() 안에 쓰인 return 식 때문에 이 함수를 람다로 정의하는 것은 어렵다.
        *  -> 익명 함수를 쓰면 이런 문제를 피할 수 있다.
        *     익명 함수는 fun 키워드를 사용해 정의하고, 함수의 이름은 없다.
        * */
        fun(session: Session): Boolean {
            if (session.title.contains("Kotlin") &&
                session.speaker in favoriteSpeakers) {
                return true
            }
        return false
    }) eq true

    sessions.any(lambdaFunction) eq true
}