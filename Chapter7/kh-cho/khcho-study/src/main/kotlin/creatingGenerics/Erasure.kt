package Chapter7.`kh-cho`.`khcho-study`.src.main.kotlin.creatingGenerics

fun main() {
    val strings = listOf("a", "b", "c")
    val all: List<Any> = listOf(1, 2, "x")
    useList(strings)
    useList(all)
}

fun useList(list: List<Any>) {
    if (list is List<*>) {}
}