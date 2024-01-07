package Chapter5.`kh-cho`.`khcho-study`.src.main.kotlin.SealedClasses

abstract class Abstract(val av: String) {
    open fun concreteFunction() {}
    open val concreteProperty = ""
    abstract fun abstractFunction(): String
    abstract val abstractProperty: String
    init {}
    constructor(c: Char) : this(c.toString())
}

open class Concrete(): Abstract("") {
    override fun concreteFunction() {}
    override val abstractProperty =""
    override fun abstractFunction() =""
    override val concreteProperty = ""
}

sealed class Sealed(val av: String) {
    open fun concreteFunction() {}
    open val concreteProperty = ""
    abstract fun abstractFunction(): String
    abstract val abstractProperty: String
    init {}
    constructor(c: Char) : this(c.toString())
}

open class SealedSubclass(): Sealed("") {
    override fun concreteFunction() {}
    override val concreteProperty = ""
    override fun abstractFunction() = ""
    override val abstractProperty = ""
}

fun main() {
    Concrete()
    SealedSubclass()
}