import Test.eq


fun main() {
    val chars = "A B C D E".split(" ")

    chars.fold("*") { acc, e -> "$acc $e" } eq
            "* A B C D E"

    chars.foldRight("*") { e, acc -> "$acc $e" } eq
            "* E D C B A"

    /*
    *  reduce()와 reduceRight() 역시 fold()와 비슷하지만,
    *  첫 번째 원소와 마지막 원소를 초기값으로 사용한다는 점이 다르다.
    * */
    chars.reduce { acc, e -> "$acc $e" } eq
            "A B C D E"

    chars.reduceRight { e, acc -> "$acc $e" } eq
            "E D C B A"
}