package Properties


val constant = 42

/*
*  최상위 프로퍼티를 선언하는 일은 안티패턴으로 간주된다.
* */
var counter = 0

fun inc() {
    counter++
}