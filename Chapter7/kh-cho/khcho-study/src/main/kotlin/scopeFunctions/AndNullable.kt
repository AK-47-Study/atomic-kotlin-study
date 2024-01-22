package Chapter7.`kh-cho`.`khcho-study`.src.main.kotlin.scopeFunctions

import atomictest.eq
import kotlin.random.Random

fun gets(): String? =
    if (Random.nextBoolean()) "str!" else null

fun main() {
    gets()?.let {
        it.removeSuffix("!") + it.length
    }?.eq("str4")
}