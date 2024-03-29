package delegationtools

import Test.eq
import Test.trace
import kotlin.properties.Delegates
import kotlin.reflect.KProperty


fun aName(
    property: KProperty<*>,
    old: String,
    new: String
) = if (new.startsWith("A")) {
    trace("$old -> $new")
    true
    } else {
    trace("Name must start with 'A'")
    false
    }

interface Captain {
    var captain: String
}

class TeamWithTraditions : Captain {
    override var captain: String
        by Delegates.vetoable("Adam", ::aName)
}

class TeamWithTraditions2 : Captain {
    override var captain: String
        // vetoable()은 새 프로퍼티 값이 어떤 조건을 만족하지 않을 때 프로퍼티가 변경되는 것을 방지할 수 있다.
        by Delegates.vetoable("Adam") {
            _, old, new ->
            if (new.startsWith("A")) {
                trace("$old -> $new")
                true
            } else {
                trace("Name must start with 'A'")
                false
            }
        }
}

fun main() {
    listOf(
        TeamWithTraditions(),
        TeamWithTraditions2()
    ).forEach {
        it.captain = "Amanda"
        it.captain = "Bill"
        it.captain eq "Amanda"
    }

    trace eq """
        Adam -> Amanda
        Name must start with 'A'
        Adam -> Amanda
        Name must start with 'A'
    """.trimIndent()
}
