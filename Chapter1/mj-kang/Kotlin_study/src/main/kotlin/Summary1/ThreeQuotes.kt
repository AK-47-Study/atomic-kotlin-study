package Summary1

fun main() {
    println(json("The Ultimate", 42))
}

fun json(q: String, a: Int) = """{
    "question" : "$q",
    "answer" : $a
}"""