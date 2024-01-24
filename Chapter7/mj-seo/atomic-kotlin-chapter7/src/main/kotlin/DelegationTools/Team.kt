package delegationtools

import Test.eq
import kotlin.properties.Delegates.observable


class Team {
    var msg = ""
    // Delegate.observable() 함수는 가변 프로퍼티의 값이 변경되는지 관찰한다.
    var captain:  String by observable("<0>") {
        prop, old, new ->
        msg += "${prop.name} $old to $new "
    }
}

fun main() {
    val team = Team()
    team.captain = "Adam"
    team.captain = "Amanda"

    team.msg eq "captain <0> to Adam captain Adam to Amanda"
}