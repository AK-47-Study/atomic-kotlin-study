package Visibility


fun main() {

    /*
    *  다른 파일에 정의한 private 멤버에 접근할 수 없다.
    *  클래스가 private인 경우에도 접근할 수 없다.
    *  함수가 private인 경우에도 안되고, 프로퍼티가 private인 경우에도 접근하지 못한다.
    * */
    recordAnimals()
    recordAnimalsCount()
}