package Chapter7.`kh-cho`.`khcho-study`.src.main.kotlin.scopeFunctions

import atomictest.trace

data class Plumbus(var id: Int)

fun display(map: Map<String, Plumbus>){
    trace("display $map")
    val pb1: Plumbus = map["main"]?.let {
        it.id += 10
        it
    } ?: return
    trace(pb1)

    val pb2: Plumbus? = map["main"]?.run {
        id += 9
        this
    }
    trace(pb2)

    val pb3: Plumbus? = map["main"]?.apply {
        id += 8
    }
    trace(pb3)

    val pb4: Plumbus? = map["main"]?.also {
        it.id += 7
    }
    trace(pb4)
}

fun main() {
    display(mapOf("main" to Plumbus(1)))
    display(mapOf("main" to Plumbus(2)))

    trace eq """
        displaying {main=Plumbus(id=1)}
        Plumbus(id=11)
        Plumbus(id=20)
         Plumbus(id=28)
          Plumbus(id=35)
          displaying {main=Plumbus(id=2)}
    """
}