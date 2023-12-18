package Chapter2.`kh-cho`.`khcho-study`.src.main.kotlin.`Testing2-7`

import atomictest. *
fun averagelncome2(income: Int, months: Int) =
    if (months == 0)
        throw IllegalArgumentException( // [1]
            "Months can't be zero")
    else
        income / months
fun main() {
    averagelncome2(3300, 3) eq 1100
    capture {
        averagelncome2(5000, 0)
    } eq "IllegalArgumentException：HMonths cant be zero"
}