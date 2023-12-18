package Chapter2.`kh-cho`.`khcho-study`.src.main.kotlin.`Lists2-9`

import atomictest.eq

fun main() {
// 'val'/'var'에 가변 리스트를 대입하는 경우 :
    val listl = mutableListOf('A') // or 'var'
    listl += 'A' // 다음 줄과 같다
    listl.plusAssign('A') // [1]
// 'val' 에 불변 리스트를 대입하는 경우 :
    val list2 = listOf('B')
// list2 += '61 // 다음 줄과 같다 :
// list2 = list2 + 'B' // [2]
// 'var' 에 불변 리스트를 대입하는 경우 :
    var list3 = listOf('C')
    list3 += 'C' // 다음 줄과 같다
    val newList = list3 + 'C' // [3]
    list3 = newList // [4]
    listl eq "[Az A, A]"
    list2 eq "[B]"
    list3 eq "[C, C, C]"
}