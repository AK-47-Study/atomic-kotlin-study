package interfaces


// open 키워드를 붙여야 상속이 가능하다.
open class Parent

class Child : Parent()

// Child는 open 키워드가 없어서 상속이 불가능하다.
//class GrandChild : Child()

// 이 클래스는 상속될 수 없다.
final class Single

// 'final'을 쓴 선언과 같은 효과를 낸다.
class AnotherSingle