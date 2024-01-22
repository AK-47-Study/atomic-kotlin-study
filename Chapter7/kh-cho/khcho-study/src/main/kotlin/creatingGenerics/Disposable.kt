package Chapter7.`kh-cho`.`khcho-study`.src.main.kotlin.creatingGenerics

interface Disposable {
    val name: String
    fun action() : String
}

class Compost(override val name: String) :
        Disposable{
    override fun action(): String = "Add to composter"
}

interface Transport: Disposable

class Donation(override val name: String) :
        Transport{
    override fun action() = "Call for pickup"
}

class Recyclable(override val name: String) :
        Transport{
    override fun action() = "Put in bin"

}

class Landfill(override val name: String) :
        Transport {
    override fun action() = "Put in dumpster"
        }

val items = listOf(
    Compost("Orange Peel"),
    Compost("Apple Care"),
    Donation("Couch"),
    Donation("Clothing"),
    Recyclable("Plastic"),
    Recyclable("Metal"),
    Recyclable("Carboard"),
    Landfill("Trash")
)

val recyclable =
    items.filterIsInstance<Recyclable>()