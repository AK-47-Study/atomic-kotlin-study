package Chapter2.`kh-cho`.`khcho-study`.src.main.kotlin.Properties

class Sofa {
    val cover: String = "Loveseat cover"
}

fun main() {
    var sofa = Sofa()
    // 다음은 허용되 않음
    // sofa.cover = "New cover"
    // var에 재대입하기
    sofa = Sofa()
}