package baseclassinit


open class SuperClass1(val i: Int)
class SubClass1(i: Int) : SuperClass1(i)

open class SuperClass2

// 기반 클래스 생성자 파라미터가 없어도, 기반 클래스 이름 뒤에 괄호를 붙이도록 강제한다.
class SubClass2 : SuperClass2()