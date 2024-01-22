package Chapter7.`kh-cho`.`khcho-study`.src.main.kotlin.scopeFunctions

import atomictest.eq

data class Tag(var n: Int = 0){
    var s: String = ""
    fun increment() = ++n
}

fun main() {
    Tag(1).let {
        it.s = "let: ${it.n}"
        it.increment()
    } eq 2

    Tag(2).let {tag ->
    tag.s = "let: ${tag.n}"
        tag.increment()
    } eq 3

    Tag(3).run {
        s = "run: $n"
        increment()
    } eq  4

    with(Tag(4)) {
        s = "with : $n"
        increment()
    } eq 5

    Tag(5).apply {
        s = "apply: $n"
        increment()
    } eq "Tag(n=6)"

    Tag(6).also {
        it.s = "also: ${it.n}"
        it.increment()
    } eq "Tag(n=7)"

    Tag(7).also { tag ->
        tag.s = "also: ${tag.n}"
        tag.increment()
    } eq "Tag(n=8)"
}