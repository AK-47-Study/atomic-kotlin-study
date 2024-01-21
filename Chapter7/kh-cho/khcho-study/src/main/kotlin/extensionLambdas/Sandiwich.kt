package Chapter7.`kh-cho`.`khcho-study`.src.main.kotlin.extensionLambdas

import atomictest.eq

open class Recipe: ArrayList<RecipeUint>()

open class RecipeUint {
    override fun toString() =
        "${this::class.simpleName}"
}

open class Operation: RecipeUint()
class Toast: Operation()
class Grill: Operation()
class Cut : Operation()

open class Ingredient: RecipeUint()
class Bread: Ingredient()
class PeanutButter: Ingredient()
class GrapeJelly: Ingredient()
class Ham: Ingredient()
class Swiss: Ingredient()
class Mustard: Ingredient()

open class Sandiwich: Recipe(){
    fun action(op: Operation) : Sandiwich{
        add(op)
        return this
    }
    fun grill() = action(Grill())
    fun toast() = action(Toast())
    fun cut() = action(Cut())
}

fun sandwich(
    fillings: Sandiwich.()-> Unit
): Sandiwich{
    val sandiwich = Sandiwich()
    sandiwich.add(Bread())
    sandiwich.toast()
    sandiwich.fillings()
    sandiwich.cut()
    return sandiwich
}

fun main() {
    val pbj = sandwich {
        add(PeanutButter())
        add(GrapeJelly())
    }

    val hamAndSWiss = sandwich {
        add(Ham())
        add(Swiss())
        add(Mustard())
        grill()
    }
    pbj eq "[Bread, Toast, PeanutButter, " +
            "GrapeJelly, Cut]"
    hamAndSWiss eq "[Bread, Toast, Ham, " +
            "Swiss, Mustard, Grill, Cut]"
}

