package StringTemplates

fun main() {
    val s = "value"

    // 문자열 안에 큰따옴표 등의 특수 문자를 넣어야 하는 경우에는 역슬래시(\)를 사용해야 한다.
    println("s = \"$s\".")

    // 큰 따옴표를 연달아 쓰는 String 리터럴을 사용하면, 역슬래시 문자를 붙이는 것과 동일하다.
    println("""s = "$s".""")
}