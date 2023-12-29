package Constructors


/*
*  클래스 본분 밖에서도 생성자 파라미터에 접근할 수 있게 하려면,
*  파라미터 목록에 var나 val을 지정해야한다.
* */
class Alien(name: String) {
    val greeting = "Poor $name"
}

fun main() {
    val alien = Alien("Mr. Meeseeks")
    println(alien.greeting)
}