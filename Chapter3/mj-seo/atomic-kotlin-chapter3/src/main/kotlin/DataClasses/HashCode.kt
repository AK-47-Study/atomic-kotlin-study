package dataclasses

import atomictest.eq


data class Key(val name: String, val id: Int)

/*
*  HashMap이나 HashSet에서는 hashCode를 equals와 함께 사용해 Key를 빠르게 검색한다.
*  -> data class를 만들면 equals와 hashCode를 알아서 생성해준다.
* */
fun main() {
    val korvo = Key("Korvo", 19)
    korvo.hashCode() eq -2041757108

    val map = HashMap<Key, String>()
    map[korvo] = "Alien"
    map[korvo] eq "Alien"

    val set = HashSet<Key>()
    set.add(korvo)
    set.contains(korvo) eq true
}