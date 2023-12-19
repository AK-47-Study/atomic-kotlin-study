package Chapter2.`kh-cho`.`khcho-study`.src.main.kotlin.`Testing2-7`

import atomictest. eq
fun averagelncome(income: Int, months: Int)=
    if (months == 0)
        null
    else
        income / months
fun main() {
    averagelncome(3300, 3) eq 1100
    averageincome(5000, 0) eq null
}