package composition


class Features {
    fun f1() = "feature1"
    fun f2() = "feature2"
}

class Form {
    /*
    *  클라이언트는 Features에 접근할 수 없다.
    *  -> Form이 어떻게 구현됬는지 알 수 없으므로, 더 나은 방법을 찾아내면
    *     features를 제거하고 새 접근 방법을 택해도 클라이언트 코드에 아무 영향이 없다.
    * */
    private val features = Features()
    fun operation1() =
        features.f2() + features.f1()

    fun operation2() =
        features.f1() + features.f2()
}