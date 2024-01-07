package Chapter5.`kh-cho`.`khcho-study`.src.main.kotlin.CompanionObjects

import atomictest.eq
import com.sun.jndi.ldap.LdapPoolManager.trace
import com.sun.tools.sjavac.Log.trace as trace1

interface ZI {
    fun f(): String
    fun g(): String
}
open class ZlOpen : ZI {
    override fun f() = "ZIOpen.f()"
    override fun g() = "ZIOpen.g()"
    class ZICompanion {
        companion object : ZlOpen()

        fun u() = trace1("${f()} ${g()}")
    }

    class ZICompanionInheritance {
        companion object : ZlOpen() {
            override fun g() =
                "ZICompanionInheritance.g()"

            fun h() = "ZICompanionInheritance.h()"
        }

        fun u() = trace1("${f()} ${g()} ${h()}")
    }

    class ZIClass {
        companion object : ZI {
            override fun f() = "ZIClass.f()"
            override fun g() = "ZIClass.g()"
        }

        fun u() = trace1("${f()} ${g()}")
    }

    fun main() {
        ZIClass.f()
        ZIClass.g()
        ZIClass().u()
        ZICompanion.f()
        ZICompanion.g()
        ZICompanion().u()
        ZICompanionInheritance.f()
        ZICompanionInheritance.g()
        ZICompanionInheritance().u()
        trace eq """
            ZIClass.f() ZIClass.g()
            ZIOpen.f() ZlOpen.g()
            ZIOpen.f()
            ZICompanionInheritance.g()
            ZICompanionInheritance.h()
        """
    }
}