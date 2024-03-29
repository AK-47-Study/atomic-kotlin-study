

inline fun <reified T : Disposable> select() =
    items.filterIsInstance<T>().map { it.name }
fun main() {
    select<Compost>() eq
            "[Orange Peel, Apple Core]"

    select<Donation>() eq "[Couch, Clothing]"

    select<Recyclable>() eq
            "[Plastic, Metal, Cardboard]"

    select<Landfill>() eq "[Trash]"
}
