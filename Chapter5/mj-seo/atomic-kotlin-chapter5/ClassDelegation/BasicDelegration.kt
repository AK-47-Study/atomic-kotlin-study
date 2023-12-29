package classdelegation


interface AI
class A : AI

/*
*  클래스를 위임할 경우 by 키워드를 인터페이스 이름 뒤에 넣고 by 뒤에 위임할 멤버 프로퍼티의 이름을 넣으면 된다.
*  -> 인터페이스에만 위임을 적용할 수 있다.
*/
class B(val a: A) : AI by a