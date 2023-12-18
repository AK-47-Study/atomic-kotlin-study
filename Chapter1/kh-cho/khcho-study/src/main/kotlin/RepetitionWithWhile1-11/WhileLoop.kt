package Chapter1.`kh-cho`.`khcho-study`.src.main.kotlin.`RepetitionWithWhile1-11`

fun main() {
    var i = 0
    while (condition(i)){
        print(".")
        i += 10
    }
}

fun condition(i: Int) = i <100
