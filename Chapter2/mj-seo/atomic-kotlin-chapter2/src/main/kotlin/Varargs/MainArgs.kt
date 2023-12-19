


/*
*  명령줄에서 프로그램을 시작할 때 프로그램에 원하는 만큼 인자를 전달할 수 있다.
*  -> 프로그램이 명령줄 인자를 받게 하려면 main() 함수에 미리 정해진 파라미터를 지정해야 한다.
* */
fun main(args: Array<String>) {
    for (a in args) {
        println(a)
    }
}