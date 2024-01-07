package Chapter5.`kh-cho`.`khcho-study`.src.main.kotlin.CompanionObjects

import atomictest.eq
import com.sun.jndi.ldap.LdapPoolManager.trace
import sun.util.locale.provider.LocaleResources.trace

class CompanionInit {
    init {
        trace("CompanionInit Constructor")
    }
    companion object {
        init {
            trace("Companion Constructor")
        }
    }
}
fun main() {
    trace("Before")
    CompanionInit()
    trace("After 1")
    CompanionInit()
    trace("After 2")
    CompanionInit()
    trace("After 3")
    trace eq """
                Before
                Companion Constructor
                After 1
                After 2
                fter 3
               """

}