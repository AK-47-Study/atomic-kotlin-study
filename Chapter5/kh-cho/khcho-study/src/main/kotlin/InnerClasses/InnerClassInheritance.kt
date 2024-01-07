package Chapter5.`kh-cho`.`khcho-study`.src.main.kotlin.InnerClasses

import atomictest.eq
import com.sun.jndi.ldap.LdapPoolManager.trace
import com.sun.tools.sjavac.Log.trace as trace1

open class Egg {
    private var yolk = Yolk()

    open inner class Yolk {
        init {
            trace1("Egg.Yolk()")
        }
        open fun f() {
            trace1("Egg.Yolk,f()")
        }
    }
    init {
        trace1("New Egg()")
    }
    fun insertYolk(y: Yolk) {
        yolk = y
    }
    fun g() {
        yolk.f()
    }
}
class BigEgg : Egg() {
    inner class Yolk : Egg.Yolk() {
        init {
            trace1("BigEgg.Yolk()")
        }

        override fun f() {
            trace1("BigEgg.Yolk,f()")
        }
    }

    init {
        insertYolk(Yolk())
    }
}
fun main() {
    BigEgg().g()
    trace eq """
            Egg.Yolk()
            New Egg()
            Egg.Yolk()
            BigEgg.Yolk()
            BigEgg.Yolk.f()
            """
}