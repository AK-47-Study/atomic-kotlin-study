package Chapter2.`kh-cho`.`khcho-study`.src.main.kotlin.`Testing2-7`

import atomictest. *
fun averageincome(income: Int, months: Int)=
income / months
fun main() {
    averageincome(3300, 3) eq 1100
    capture {
        averageincome(5000, 0)
    } eq "ArithmeticException: / by zero"
}