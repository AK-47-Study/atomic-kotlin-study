package Chapter7.`kh-cho`.`khcho-study`.src.main.kotlin.scopeFunctions

import atomictest.trace

val functions = listOf(
    fun (name: String?) {
        name
            ?.takeUnless { it.isBlank() }
            ?.let { trace("$it in let") }
    },
    fun (name: String?) {
        name
            ?.takeUnless { it.isBlank() }
            ?.run { trace("$this in run") }
    },

    fun (name: String?) {
        name
            ?.takeUnless { it.isBlank() }
            ?.also { trace("$it in also") }
    }
)

fun main() {
    functions.forEach{it(null)}
    functions.forEach{it(" ")}
    functions.forEach{it("Yumyulack")}
    trace eq  """
        Yumyulack in let 
        Yumyulack in run 
        Yumyulack in apply 
        Yumyulack in also
    """
}