import Test.eq


fun main() {
    /*
    *  fold()는 원소를 왼쪽에서 오른쪽으로 처리하고,
    *  foldRight()는 오른쪽에서 시작해 왼쪽 방향으로 원소를 처리한다.
    * */
    val list = listOf('a', 'b', 'c', 'd')
    list.fold("*") { acc, elem ->
        "($acc) + $elem"
    } eq "((((*) + a) + b) + c) + d"

    list.foldRight("*") { elem, acc ->
        "$elem + ($acc)"
    } eq "a + (b + (c + (d + (*))))"
}