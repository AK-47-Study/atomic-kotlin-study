package Chapter5.`kh-cho`.`khcho-study`.src.main.kotlin.InnerClasses

import atomictest.eq
import com.sun.jndi.ldap.LdapPoolManager.trace
import com.sun.tools.sjavac.Log.trace as trace1

fun interface Counter {
    fun next(): Int
}
object CounterFactory {
    private var count = 0
    fun new(name: String): Counter {
        class Local : Counter {
            init {
                trace1("Local()")
            }
            override fun next(): Int {
                trace1("$name $count")
                return count++
            }
        }
        return Local()
    }
    fun new2(name: String): Counter {
        return object : Counter {
            init {
                trace1("Counter()")
            }
            override fun next(): Int {
                trace1("$name $count")
                return count++
            }
        }
    }

    fun new3(name: String): Counter {
        trace1("Counter()")
        return Counter { // SAM 변환
            trace1("$name $count")
            count++
        }
    }
}
fun main() {
    fun test(counter: Counter) {
        (0..3).forEach { counter.next() }
    }
    test(CounterFactory.new("Local"))
    test(CounterFactory.new2("Anon"))
    test(CounterFactory.new3("SAM"))
    trace eq """
                Local() Local 0 Local 1 Local 2 Local 3
             """
}