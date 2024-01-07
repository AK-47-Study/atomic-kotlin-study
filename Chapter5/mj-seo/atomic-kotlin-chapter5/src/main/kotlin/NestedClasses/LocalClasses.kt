package nestedclasses


fun localClasses() {
    // 지역 open 클래스는 거의 정의하지 않아야 한다.
    open class Amphibian
    class Frog : Amphibian()
    val amphibian: Amphibian = Frog()
}