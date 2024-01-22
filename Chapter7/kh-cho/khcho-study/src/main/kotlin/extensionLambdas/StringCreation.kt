package Chapter7.`kh-cho`.`khcho-study`.src.main.kotlin.extensionLambdas

import atomictest.eq
import java.lang.StringBuilder

private fun messy(): String {
    val built = StringBuilder()
    built.append("ABCs: ")
    ('a' .. 'x').forEach{ built.append(it)}
    return built.toString()
}

private fun clean() = buildString {
    append("ABCs: ")
    ('a' .. 'x').forEach{append((it))}
}

private fun cleaner() =
    ('a'..'x').joinToString ("", "ABCs: ")

fun main() {
    messy() eq  "ABCs: ababcdefghijklmnopqrstuvwx"
    messy() eq clean()
    clean() eq cleaner()
}