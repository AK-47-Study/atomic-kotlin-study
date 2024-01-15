package ExtensionLambdas

import Test.eq

open class Recipe : ArrayList<RecipeUnit>()

open class RecipeUnit {
    override fun toString() =
        "${this::class.simpleName}"
}

open class Operation : RecipeUnit()
class Toast  : Operation()
class Grill : Operation()
class Cut : Operation()

open class Ingredient : RecipeUnit()
class Bread : Ingredient()
class PeanutButter : Ingredient()
class GrapeJelly : Ingredient()
class Ham : Ingredient()
class Swiss : Ingredient()
class Mustard : Ingredient()

open class Sandwich : Recipe () {
    private fun action(op: Operation): Sandwich {
        add(op)
        return this
    }
    fun grill() = action(Grill())
    fun toast() = action(Toast())
    fun cut() = action(Cut())
}

fun sandwich(
    // fillings 확장 람다는 호출자가 Sendwich를 여러가지 설정으로 준비할 수 있게 해준다.
    fillings: Sandwich.() -> Unit
) : Sandwich {
    val sandwich = Sandwich()
    sandwich.add(Bread())
    sandwich.toast()
    sandwich.fillings()
    sandwich.cut()
    return sandwich
}

fun main() {
    val pbj = sandwich {
        add(PeanutButter())
        add(GrapeJelly())
    }

    val hamAndSwiss = sandwich {
        add(Ham())
        add(Swiss())
        add(Mustard())
        grill()
    }

    pbj eq "[Bread, Toast, PeanutButter, " +
            "GrapeJelly, Cut]"

    hamAndSwiss eq "[Bread, Toast, Ham, " +
            "Swiss, Mustard, Grill, Cut]"
}