package Chapter2.`kh-cho`.`khcho-study`.src.main.kotlin.`Lists2-9`

import atomictest.eq

fun main() {
    var list = listOf('X') // 불변 리스트
    list += 'Y' // 가변 리스트처럼 보임
    list eq "[XZ Y]"
}